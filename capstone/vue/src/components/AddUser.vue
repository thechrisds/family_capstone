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
        password: "",
        role: "ROLE_USER"
      };
    },
  },
};
</script>

<style>
.new-user-form {
  display: flex;
  flex-direction: column;
  width: 200px;
  border: solid, 2px, gray;
}

.submitUser:hover {
  background-image: '"../assets/bookturner-small.gif"';
    background-size: contain;
}

</style>