<template>
  <div id="add-user">
    <h4 class="add-user-title">Add.</h4>
    <form class="new-user-form">
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
        role: "ROLE_USER",
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
        role: "ROLE_USER",
      };
    },
  },
};
</script>

<style>
#add-user {
  display: flex;
  align-items: center;
  width: 350px;
  flex-direction: column;
  padding-bottom: 10px;
  border-radius: 10px;
  background-color:#24305e;
  height:300px;
}

.submitUser {
  background-color: white;
  border-radius: 5px;
  border: lightgray 2px solid;
  box-shadow: 2px 2px 2px grey;
  font-size: 12px;
}

.submitUser:hover {
  background-color: rgb(37, 226, 78);
}

.add-user-title {
  color: #f76c6c;
  font-weight: 600;
  font-size: 16px;
  margin-top: 15px;
  margin-right: 250px;
}

.new-user-form{
  display: flex;
  flex-direction: column;
 margin: auto;
 width:70%;
 padding-bottom:20px;
 border-radius: 10px;
}
</style>