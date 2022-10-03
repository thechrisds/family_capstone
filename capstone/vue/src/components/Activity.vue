<template>
  <div class="logged-activity-container">

    <div
      class="activityList"
    >
      <h2 class="activity-reader"> {{ "User: " + userName }}</h2>
      <h3 class="activity-book">{{ "Book: " + bookTitle }}</h3>
      <h3 class="activity-date">{{ "Date Read: " + dateRead }}</h3>
      <h3 class="activity-minutes">
        {{ "Minutes Read: " + timeInMinutes }}
      </h3>
      <p class="activity-notes">{{ "Notes: " + activityNotes }}</p>
    </div>
  </div>
</template>

<script>
//import activityService from "@/services/ActivityService.js";
export default {
  name: "view-activity",
  props:{
    userName: String,
    bookTitle: String,
    dateRead: String,
    timeInMinutes: Number,
    activityNotes: String,
    testProp: String,
    },
  data() {
    return {
     // activities: [],
      //users: [],
      //id: "",
      username: this.$store.state.user.username,
    };
  },
  created() {
    console.log(this.testProp);
    /*activityService.seeFamilyActivity().then((response) => {
      console.log(response);
      this.activities = response.data;
    }).catch,
      activityService.see;
      */
  },
};
</script>

<style>
.logged-activity-container {
  display: flex;
  justify-content: space-evenly;
  align-content: center;
}


.activityList {
  border-top: 10px rgb(221, 105, 250) solid;
  border-right: 10px rgb(133, 60, 161) solid;
  border-bottom: 10px solid rgb(65, 15, 80);
  border-left: 10px solid rgb(217, 161, 255);
  box-shadow: 5px 5px 15px rgb(107, 3, 155);  
  width: 250px;
  min-width: 200px;
  text-align: center;
  background-color: rgb(255, 255, 255);
  margin-top:50px;
  margin-left:40px;
  margin-right: 40px;
}

.activity-reader{
  font-size:25px;
}

.activity-book{
  font-size: 20px;
}

.activity-date{
  font-size: 20px;
}

.activity-minutes{
  font-size: 20px;
}


</style>