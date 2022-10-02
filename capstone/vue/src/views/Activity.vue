<template>
  <div id="activity-main">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else class="activity-main">
      <div class="activity-sub">
        <activity />
      </div>
      <div id="add-activities">
        <add-activity />
      </div>
    </div>
  </div>
</template>

<script>
import Activity from "@/components/Activity";
import AddActivity from "@/components/AddActivity";

export default {
  data() {
    return {
      isLoading: true,
    };
  },

  components: {
    Activity,
    AddActivity,
  },
  created() {
    setTimeout(() => {
      this.isLoading = false;
    }, 1250);
  },
};
</script>

<style>
.activity-main {
  margin-top: 150px;
  display: flex;
  flex-wrap: wrap;
  flex-direction: column;

}

.activity-sub {
  height: 275px;
  background-color:rgb(242, 255, 254);
  border: solid 1px rgb(48, 48, 124);
  box-shadow: 5px 5px 15px rgb(58, 58, 97);
}

#add-activities {
  flex:center;
  text-align: center;
  border: solid 1px rgb(48, 124, 58);
  box-shadow: 5px 5px 15px rgb(58, 97, 66);
  width: 450px;
  height: 550px;
}
</style>