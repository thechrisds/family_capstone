<template>
  <div id="account-list">
    <div class="top-account-bar">Family.</div>
    <div class="fm-cards">
      <div class="family-members" v-for="user in users" v-bind:key="user.id">
        <h5>Username: {{ user.username }}</h5>

        Name: {{ user.firstname }} {{ user.lastname }}
        <br />
        <br />
        Total minutes read: {{ user.totalMinutes }} minutes.
        <br /><br>
        <button class="delete-user" v-on:click="deleteMember(user.id)">
          Delete Member
        </button>
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
      username: this.$store.state.user.username,
      firstname: this.$store.state.user.firstname,
      lastname: this.$store.state.user.lastname,
      totalminutes: this.$store.state.user.totalminutes,
      id: this.$store.state.user.id,
    };
  },
  methods: {
    deleteMember(id) {
      accountService
        .deleteUser(id)
        .then((response) => {
          console.log("delete response: ", response);
          this.$mount;
          if (response.status === 204) {
            alert("Member successfully deleted");
            this.$router.go('/account');
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg = "Error deleting member.";
          }
        });
    },
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

.top-account-bar {
  overflow: hidden;
  height: 25px;
  margin-top:15px;
  margin-left:-15px;
  width: 100%;
  font-size: 16px;
  color:white;
  font-weight:600;
}

.family-members {
  width: 250px;
  background-color: white;
  border-radius: 10px;
  padding-bottom: 10px;
  margin-top: 20px;
  margin-left:auto;
  margin-right:auto;
  padding-left:20px;
  padding-top:5px;
}

.fm-cards{
  display: flex;
  flex-direction: column;
  font-size:1vw;
  justify-content: space-evenly;
  margin: 10px;

}
.delete-user {
  background-color: white;
  border-radius: 5px;
  border: lightgray 2px solid;
  box-shadow: 2px 2px 2px grey;
  font-size: 12px;
}

.delete-user:hover {
  background-color: rgb(226, 37, 37);
}
</style>