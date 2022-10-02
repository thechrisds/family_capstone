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
      <h2 class="activity-reader">{{ "User: " + activity.userName }}</h2>
      <h3 class="activity-book">{{ "Book: " + activity.bookTitle }}</h3>
      <h3 class="activity-date">{{ "Date Read: " + activity.dateRead }}</h3>
      <h3 class="activity-minutes">
        {{ "Minutes Read: " + activity.timeInMinutes }}
      </h3>
      <p class="activity-notes">{{ "Notes: " + activity.activityNotes }}</p>
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
.logged-activity-container {
  display: flex;
  justify-content: space-evenly;
}

.la-title {
  background-color: rgb(115, 115, 180);
}

.activityList {
  border: 2px rgb(98, 154, 219) solid;
  border-radius: 20px;
  width: 300px;
  margin: 20px;
  min-width: 200px;
  text-align: center;
  background-color: rgb(232, 250, 255);
}
</style>