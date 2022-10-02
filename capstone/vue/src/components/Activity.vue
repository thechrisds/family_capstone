<template>
  <div class="logged-activity-container">
    <div class="la-title">
    <h2>Logged Family Reading</h2>
    </div>
    <div
      class="activityList"
      v-for="activity in activities"
      v-bind:key="activity.userName"
      v-bind:activity="activity"
    >
      <h2 class="activity-reader">{{ activity.userName }}</h2>
      <h3 class="activity-book">{{ activity.bookTitle }}</h3>
      <p class="activity-date">{{ activity.dateRead }}</p>
      <p class="activity-minutes">{{ activity.timeInMinutes }}</p>
      <p class="activity-notes">{{ activity.activityNotes }}</p>
      <p class="null-notes" v-if="!activity.activityNotes">No notes taken</p>
    </div>
  </div>
</template>

<script>
import activityService from "@/services/ActivityService.js";
export default {
  name: "view-activity",
  data() {
    return {
      activities: [],
      users: [],
      id: "",
      username: this.$store.state.user.username,
    };
  },
  created() {
    activityService.seeFamilyActivity().then((response) => {
      console.log(response);
      this.activities = response.data;
    }).catch,
      activityService.see;
  },
};
</script>

<style>

.logged-activity-container{
  margin-top:150px;
  
}

.la-title{
  background-color:rgb(115, 115, 180);
}

.activityList {
  border: 2px rgb(161, 75, 41) solid;
  border-radius: 10px;
  width: 175px;
  margin: 20px;
  margin-bottom: 20px;
  margin-top: 20px;
 
  background-color: rgb(255, 242, 233);
}
</style>