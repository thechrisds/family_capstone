<template>
  <div class="add-activity-container">
    <h2 class="add-activity-title">Record.</h2>
    <div class="add-activity-form-container">
      <form v-on:submit.prevent="submitForm" class="new-activity-form">
        <label for="userName">Reader: </label>
        
        <select name="" id="username-dropdown" v-model="activity.readerId">
          <option disabled value="">Select a user</option>
          <option v-for="user in users" v-bind:key="user.readerId">
        {{user.username}} | User ID: <p id="user-id">{{user.id}}</p>
        </option>
        </select>
        <label for="title">What did you read?</label>

        <input
          type="text"
          placeholder="Book Id"
          name="current-book"
          id="current-book"
          v-model="activity.isbn"
        />

        <label for="minutes">Minutes read: </label>
        <input
          type="number"
          placeholder="Number of minutes"
          name="minutes"
          id="logged-minutes"
          v-model="activity.timeInMinutes"
        />
        <br />
        <label for="read-type">How did you read?</label>
        <select
          name="read-type"
          type="number"
          id="type"
          v-model="activity.formatId"
        >
          <option value="" disabled selected>Please Select Type</option>
          <option value="1">Paper</option>
          <option value="2">Digital</option>
          <option value="3">Audiobook</option>
          <option value="4">Read-Aloud(Reader)</option>
          <option value="5">Read-Aloud(Listener)</option>
          <option value="0">Other</option>
        </select>
        <label for="notes"></label>
        <input
          type="text"
          placeholder="Enter any notes (Optional)"
          name="notes"
          id="add-activity-notes"
          v-model="activity.activityNotes"
        />
        <div class="add-activity-sub-reset-buttons">
          <input class="add-activity-reset" type="reset" />
          <input class="add-activity-submit" type="submit" />
          
        </div>
      </form>
    </div>
    
  </div>
</template>

<script>
import ActivityService from "@/services/ActivityService.js";
import AccountService from "@/services/AccountService.js";

// dropdown script
// var userId = document.getElementById('user-id');
// var readerId = document.getElementById('reader-Id');
// userId.onchange = function() {
//   readerId.value = userId.value;
// } 

export default {
  name: "add-activity",
  data() {
    return {
      activity: {
        isbn: "",
        timeInMinutes: 0,
        formatId: 0,
        activityNotes: "",
        readerId: ""
      },
      users: [],
      username: this.$store.state.user.username,
      firstname: this.$store.state.user.firstname,
      lastname: this.$store.state.user.lastname,
      totalminutes: this.$store.state.user.totalminutes,
      id: this.$store.state.user.id,
    };
  },
  components: {},
  computed: {
    getReaderId(){
      return this.activity.readerId.substring(this.activity.readerId.length - 1);}
  },
  methods: {
    submitForm() {
      const activity = {
        readerId: this.activity.readerId.substring(this.activity.readerId.length - 1),
        isbn: this.activity.isbn,
        timeInMinutes: this.activity.timeInMinutes,
        formatId: this.activity.formatId,
        activityNotes: this.activity.activityNotes,
      };
      window.alert("Activity Saved!"), window.location.reload();
      ActivityService.addActivity(activity).then((response) => {
        this.$store.commit("SET_ACTIVITY", response.data);
      });
    },
  },
  created() {
    setTimeout(() => {
      this.isLoading = false;
    }, 1250);
    console.log(this.username);
    console.log("firstname: ", this.firstname);
    AccountService.getFamilyId(this.username).then((response) => {
      console.log(response);
      this.id = response.data;
      AccountService
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

<style scoped>
#readerId {
  box-shadow: 1px 1px 2px gray;
}

#current-book {
  box-shadow: 1px 1px 2px gray;
}

#logged-minutes {
  box-shadow: 1px 1px 2px gray;
}

#type {
  box-shadow: 1px 1px 2px gray;
}

.new-activity-form{
padding-bottom:40px;
width:100%;
}

#add-activity-notes {
  box-shadow: 1px 1px 2px gray;
}

.add-activity-title {
  height: 25px;
  text-align:left;
  margin-top: 20px;
  margin-left:20px;
  width: 100%;
  font-size: 18px;
  color: white;
  font-weight: 600;
}

.add-activity-sub-reset-buttons {
  display: flex;
  align-content: center;
  justify-content: space-evenly;
  margin-top:10px;
}


.add-activity-reset {
background-color: #f8e9a1;
border-radius: 4px;
border: none;
height:50px;
width:100px;
color:#24305e;
}

.add-activity-container {
  display: flex;
  flex-direction: column;
  width: 100%;
  height: auto;
  margin-left: auto;
  margin-right: auto;
  background-color:#24305e;
  border-radius: 10px;
  
}

.add-activity-form-container {
  display: flex;
  flex-direction: column;
  text-align: center;
  width: 90%;
  padding: 15px;
  margin-left:auto;
  margin-right:auto;
  color:white;
  margin-top:-20px;
}

input[type="text"],
select,
textarea {
  width: 100%;
  padding: 5px;
  border-radius: 10px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type="submit"] {
  background-color: #f76c6c;
  color: #24305e;;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

.row:after {
  content: "";
  display: table;
  clear: both;
}

@media screen and (max-width: 600px) {
  .col-25,
  .col-75,
  input[type="submit"] {
    width: 100%;
    margin-top: 0;
  }
}
</style>
