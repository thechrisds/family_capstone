<template>
  <div id="activity">
    <activity />
    <div class="activities">
      <router-link to="/activity/add"> Add Activity </router-link>
    </div>
  </div>
</template>

<script>
import Activity from "@/components/Activity";

export default ({
  components: {
    Activity
  }
});
</script>

<style>
.activities{
    text-align:center;
}
</style>