<template>
  <div id="account-list">
    <div class="account-list-title">Family.</div>
    <!-- <div class="fm-cards">
      <div
        class="family-member-card"
        v-for="user in users"
        v-bind:key="user.id"
        v-bind:user="user"
        @click="
          () => {
            setUser(user);
          }
        "
        v-b-modal.add-activity-modal
      >
        <h5 class="member-name">{{ user.username }}</h5>

        Name: {{ user.firstname }} {{ user.lastname }}
        <br />
        <br />
        Total minutes read: {{ user.totalMinutes }} minutes. <br /><br />
        <div class="al-card-buttons">
          <button class="delete-user" v-on:click="deleteMember(user.id)">
            Delete Member
          </button>
          <div>
            <button
              class="modal-button"
              v-bind:user="user"
              v-bind:key="user.id"
              @click="
                () => {
                  setUser(user);
                }
              "
              v-b-modal.modal-center
            >
              Add Reading
            </button>
          </div>
        </div>
      </div>
      <b-modal id="add-activity-modal"> <add-activity /> </b-modal>
    </div> -->
    <div class="family-members-chart">
      <b-table 
      hover
      :items="users"
      :fields="fields"
      :sort-by.sync="sortBy"
      :sort-desc="true"
      :tbody-tr-class="rowClass"
      :sticky-header="true"
      class="family-members-table">
      </b-table>
    </div>
<!-- 

 -->


  </div>
</template>

<script>
//modal

//-----
// import AddActivity from "@/components/AddActivity";
import accountService from "@/services/AccountService.js";

export default {
  name: "account-list",
  isLoading: true,
  //props: ['users'],
  components: {
    // AddActivity,
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
      
      fields:[
        {
          key: "id",
          label: "ID #"
        },
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
        {
          key:"addActivity",
          label: "Record Reading",
          sortable: false,
        },
      ],
    };
  },
  methods: {
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

#account-list-box {
  width: 100%;
  height:300px;
  border-radius: 10px;

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
  padding-bottom: 18px;
  width: 100%;
  font-size: 18px;
  color: #24305e;
  font-weight: 600;
}

.family-members-chart{
  width:80%;
  margin:auto;
  background-color: #a8d0e6;
  border-radius: 10px;
}

.member-name {
  font-size: 15px;
}

.family-member-card {
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
}

.fm-cards::-webkit-scrollbar {
  width: 5px; /* width of the entire scrollbar */
}

.fm-cards::-webkit-scrollbar-thumb {
  background-color: rgb(216, 181, 181); /* color of the scroll thumb */
  border-radius: 5px; /* roundness of the scroll thumb */
}
.fm-cards::-webkit-scrollbar-track {
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
  background-color: white;
  border-radius: 5px;
  border: lightgray 2px solid;
  box-shadow: 2px 2px 2px grey;
  font-size: 10px;
  height: 80%;
  margin-left:-10px;
}

.delete-user:hover {
  background-color: rgb(226, 37, 37);
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