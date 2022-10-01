<template>
  <div id="add-user">
    <form class="new-user-form">
      Add a member to your family:
      <input
        class="user-name"
        type="text"
        placeholder="Username"
        v-model="user.username"
      />
      <input
        class="first-name"
        type="text"
        placeholder="Firstname"
        v-model="user.firstname"
      />
      <input
        class="last-name"
        type="text"
        placeholder="Lastname"
        v-model="user.lastname"
      />
      <input
        class="password"
        type="text"
        placeholder="Password"
        v-model="user.password"
      />
      <input
        class="confirm-password"
        type="text"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
      />

      <button class="submitUser" v-on:click="addUser()">Add member</button>
    </form>
  </div>
</template>

<script>
import accountService from "@/services/AccountService.js";
export default {
  name: "add-user",
  data() {
    return {
      user: {
        username: "",
        firstname: "",
        lastname: "",
        password: "",
        confirmPassword: "",
        role: "ROLE_USER"
      },
    };
  },
  methods: {
    addUser() {
      accountService.addUser(this.user).then((response) => {
        console.log(response);
        if (response.status === 200) {
          alert("User created!");
        }
      });
      this.user = {
        username: "",
        firstname: "",
        lastname: "",
        password: "",
        role: "ROLE_USER"
      };
    },
  },
};
</script>

<style>
#add-user {
  display: flex;
  align-items: center;
  width: 200px;
  border: solid, 2px, gray;
  margin-left:25px;
  padding-bottom: 10px;

}

.submitUser{
    background-color: white;
  border-radius: 5px;
  border:lightgray 2px solid;
  box-shadow: 2px 2px 2px grey;
  font-size: 12px;
}

.submitUser:hover {
  background-color: rgb(37, 226, 78);
}



</style>