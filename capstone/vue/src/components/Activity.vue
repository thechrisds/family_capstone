<template>
  <div class="container">
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
      username: this.$store.state.user.username
    };
  },
  created() {
    activityService.seeFamilyActivity().then((response) => {
      this.activities = response.data;
    }).catch,
    activityService.see
  },
};
</script>

<style scoped>
</style>