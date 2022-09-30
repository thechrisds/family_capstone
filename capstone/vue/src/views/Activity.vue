<template>
  <div id="activity">
    <activity />
    <div class="familyactivity">
      <router-link to="/activity/user"> Add activity! </router-link>
    </div>
  </div>
</template>

<script>
import Activity from "@/components/Activity";

export default {
  components: {
    Activity,
  },
};
</script>
