<template>
  <div id="account-list">
    <div class="account-list-title">Family.</div>

    <div class="family-members-chart">
      <b-table 
      hover
      :items="users"
      :fields="fields"
      :sort-by.sync="sortBy"
      :sort-desc="true"
      :tbody-tr-class="rowClass"
      :sticky-header='stickyHeader'
      :borderless='true'
      :striped="true"
      :small="true"
      class="family-members-table">
      <template #cell(deleteUser)="data">
        <div class="delete-user">
          <b-button  class='delete-button' size="sm" variant="danger" @click="deleteMember(data.item.id)">
            Delete Member
          </b-button>
        </div>
        </template>
  
      </b-table>

    </div>
<!-- 

 -->
<div class="add-activity-modal-div">
          <button  class='add-activity-modal-btn' v-b-modal.add-activity-modal>
            Log Reading.
          </button>
          <b-modal 
          id="add-activity-modal" 
          hide-footer=true
          > 
          <add-activity /> 
          </b-modal>
        </div>

  </div>
  
</template>

<script>

import AddActivity from "@/components/AddActivity";
import accountService from "@/services/AccountService.js";

export default {
  name: "account-list",
  isLoading: true,
  //props: ['users'],
  components: {
    AddActivity,
  },
  data() {
    return {
      users: [],
      username: this.$store.state.user.username,
      firstname: this.$store.state.user.firstname,
      lastname: this.$store.state.user.lastname,
      totalminutes: this.$store.state.user.totalminutes,
      id: this.$store.state.user.id,
      sortBy:'totalMinutes',
      sortDesc:'false',
      stickyHeader:'200px',
      
      fields:[
        {
          key: "username",
          label: "Username",
          sortable: false,
        },
        {
          key: "firstname",
          label: "First name",
          sortable: false,
        },
        {
          key:"lastname",
          label: "Last name",
          sortable: false,
        },
        {
          key: "totalMinutes",
          label: "Total Minutes",
          sortable:false,
        },
        {
          key:"deleteUser",
          label: "Delete User?",
          sortable:false,
          
        },
        // {
        //   key:"addActivity",
        //   label: "Record Reading",
        //   sortable: false,
        // },
      ],
    };
  },
  methods: {

    rowClass(user, type) {
       console.log("user: ", user)
      if (!user || type !== 'row') return
      if(user[1]) return 'table-warning'
    },

    // rowClass(item, type) {
    //   if (!item || type !== 'row') return
    //   let mostMin = item[0].totalMinutes;
    //   for(let i = 1; i < item.length; i++ ) {
    //     console.log("fields.totalMinutes: ", item[i].totalMinutes);
    //     if(item[i].totalMinutes > mostMin) {
    //       mostMin = item[i].totalMinutes;
    //     }
    //   }
    //   if(item.totalMinutes === mostMin) return 'table-warning'
    // },

    deleteMember(id) {
      accountService
        .deleteUser(id)
        .then((response) => {
          console.log("delete response: ", response);
          this.$mount;
          if (response.status === 204) {
            alert("Member successfully deleted");
            this.$router.go("/account");
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg = "Error deleting member.";
          }
        });
    },
    setUser(item, user) {
      user = item;
      console.log("item: ",item);
      console.log("user:", user);
    
    },
  },
  created() {
    console.log(this.username);
   
    accountService.getFamilyId(this.username).then((response) => {
      console.log(response);
      console.log("firstname: ", this.firstname);
    console.log("totalminutes: ",this.totalMinutes);
      this.id = response.data;
      accountService
        .getAllFamily(this.id)
        .then((response) => {
          console.log("getAllFamilyResponse: ", response);
          if (response.status === 200) {
            this.users = response.data;
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg = "Error getting all Family Members.";
          }
        });
    });
  },
};
</script>


<style>
body {
  font-weight: 700;
  font-size: 12px;
}

.add-activity-modal-btn{
  border:none;
  background:none;
  font-size: 18px;
  color: #24305e;
  font-weight: 600;
}

#account-list-box {
  width: 100%;
  height:300px;
  border-radius: 10px;
  
}
.add-activity-modal-div {
  align-self: flex-end;
  margin-right:45px;
  padding-top:10px;
}
#account-list {
  display: flex;
  justify-content: center;
  flex-direction: column;
  border-radius: 10px;
  padding-bottom: 25px;
  background-color: #f76c6c;
  height: 100%;
  width: 100%;
}
.account-list-title {
  height: 25px;
  margin-left: 30px;
  width: 100%;
  font-size: 18px;
  color: #24305e;
  font-weight: 600;
  padding-top:15px;
}

.family-members-chart{
  width:90%;
  margin-top:20px;
  margin-left:auto;
  margin-right:auto;
  background-color: white;
  border-radius: 10px;

}

.member-name {
  font-size: 15px;
}

.family-members-table{
  
}

/* .family-member-card {
  width: 200px;
  background-color: white;
  border-radius: 10px;
  padding-bottom: 10px;
  margin-top: 20px;
  margin-left: auto;
  margin-right: auto;
  padding-left: 20px;
  padding-top: 5px;
}

.fm-cards {
  display: flex;
  width: 90%;
  flex-wrap: wrap;
  font-size: 1vw;
  margin: 10px;
  margin-left: 10px;
  padding-bottom: 30px;
  overflow-x: hidden;
  overflow-y: scroll;
  scroll-behavior: smooth;
  height: 70%;
} */

.family-members-table::-webkit-scrollbar {
  width: 8px; /* width of the entire scrollbar */
}

.family-members-table::-webkit-scrollbar-thumb {
  background-color: #24305e; /* color of the scroll thumb */
  border-radius: 5px; /* roundness of the scroll thumb */
}
.family-members-table::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px rgb(211, 178, 178);
  border-radius: 5px;
}

.al-card-buttons {
  display: flex;
  justify-content:space-between;
  height: 30px;
  width: 100%;
}
.delete-user {
  font-size: 2px;
  width:100%;
  height:auto;
}



.modal-button{
  background-color: white;
  border-radius: 5px;
  border: lightgray 2px solid;
  box-shadow: 2px 2px 2px grey;
  font-size: 10px;
  height: 80%;
  margin-right:10px;
}

.add-activity-for-user {
  background-color: white;
  border-radius: 5px;
  border: lightgray 2px solid;
  box-shadow: 2px 2px 2px grey;
  font-size: 10px;
  height: 80%;
}

.modal-button:hover {
  background-color: rgb(32, 202, 32);
}

/* change for update */
</style>