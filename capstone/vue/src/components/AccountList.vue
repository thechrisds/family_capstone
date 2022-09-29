<template>
  <div id="account-list">
    <div class="top-account-bar">
      Family Members
    </div>
    <div class="family-members" v-for="user in users" v-bind:key="user.id">
      ----
      <h3>Username: {{ user.username }}</h3>
      
      <br>
      First name:
      <br>
      Last name:
      <br>
      Minutes read:
      <p>

      </p>
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
    };
  },
  methods: {},
  created() {
    console.log(this.username);
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
  overflow: hidden;
  font-weight: 700;
  font-size: 12px;
}
#account-list {
  display:flex;
  flex-direction: column;
}
.top-account-bar{
  height: 25px;
  background-color: lightpink;
 width: 100%;
}

.family-members{
  align-items: center;
}


</style>