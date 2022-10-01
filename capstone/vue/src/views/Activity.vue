<template>
  <div id="activity">
    <activity />
    <div id="activities">
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

.activity{
  margin-top:100px;
}
.activities{
    text-align:center;
    margin-top: 400px;
    border: 5px;
}
</style>