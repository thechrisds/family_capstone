<template>
  <div id="account-list">
    <div class="top-account-bar">Family Members</div>
    <div class="family-members" v-for="user in users" v-bind:key="user.id">
      <h3>Username: {{ user.username }}</h3>
      
      Name: {{ user.firstname }} {{ user.lastname }}
      <br>
      <br>
      Total minutes read:
      <br>
      <div class="card-avatar">
        <button class="delete-user" v-on:click="deleteUser(user.id)">Delete Member</button>
      </div>
    </div>
  </div>
</template>

<script>
import accountService from "@/services/AccountService.js";
export default {
  name: "account-list",
  isLoading: true,
  //props: ['users'],
  data() {
    return {
      users: [],
      id: "",
      username: this.$store.state.user.username,
      firstname: this.$store.state.user.firstname,
      lastname: this.$store.state.user.lastname,
    };
  },
  methods: {
    deleteUser(id) {
      accountService.deleteUser(id).then(response => {
        if(response.status === 200) {
          alert('Member successfully deleted')
        }
      })
      .catch((error) => {
        if(error.response) {
          this.errorMsg = "Error deleting member."
        }
      }); 
    }
  },
  created() {
    console.log(this.username);
    console.log("firstname: ", this.firstname);
    accountService.getFamilyId(this.username).then((response) => {
      console.log(response);
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
#account-list {
  display: flex;
  flex-direction: column;
  height: 100%;
  align-content: center;
  justify-content: space-evenly;
  padding-bottom: 25px;
}
.top-account-bar {
  overflow: hidden;
  height: 25px;
  background-color: lightpink;
  width: 100%;
  font-size: 16px;;
  
}

.family-members {
  width: 300px;
  
  border: solid 3px lavender;
  box-shadow: 5px 5px 3px lavender;
  border-radius: 10px;
  padding-bottom: 10px;
}

.delete-user{
  background-color: white;
  border-radius: 5px;
  border:lightgray 2px solid;
  box-shadow: 2px 2px 2px grey;
  font-size: 12px;
}

.delete-user:hover {
  background-color: rgb(226, 37, 37);
}
</style>