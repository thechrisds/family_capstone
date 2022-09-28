<template>
  <div>
    <form class="new-user-form">
      <input
        class="user-name"
        type="text"
        placeholder="UserName"
        v-model="user.username"
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
        placeholder="ConfirmPassword"
        v-model="user.confirmPassword"
      />

      <button class="submitUser" v-on:click="addUser()">Save</button>
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
        password: "",
        confirmPassword: "",
        role: ""
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
        password: "",
      };
    },
  },
};
</script>

<style>
</style>