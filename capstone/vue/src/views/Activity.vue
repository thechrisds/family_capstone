<template>
  <div id="activity-main">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else class="activity-main-loaded">
      <div class="activity-sub">
        <h2 class="la-title">Logged Family Reading Activities</h2>
        <div class="activities-carousel">
        <div
          id="carouselExampleIndicators"
          class="carousel slide"
          data-bs-ride="true"
        >
          <div class="activity-carousel-inner">
            <div v-for="activity in activities" :key="activity.id">
              <div class="carousel-item active">
                <activity v-bind="activity" />
              </div>
            </div>
          </div>

          <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carouselExampleIndicators"
            data-bs-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carouselExampleIndicators"
            data-bs-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
        </div>
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
import activityService from "@/services/ActivityService.js";

export default {
  data() {
    return {
      isLoading: true,
      activities: [],
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
    activityService.seeFamilyActivity().then((response) => {
      console.log("response: ", response.data);
      this.activities = response.data;
    }).catch,
      activityService.see;
  },
};
</script>

<style>
#activity-main {
  margin-top: 70px;
}

.la-title{
  background-color: plum;
  width: 90%;
  align-self: center;
  margin:auto;
}

.activities-carousel{
  height: 325px;
  background-color: rgb(168, 140, 182);
  margin-top:70px;
}

.activity-sub {
  background-color: hsl(0, 0%, 100%);
  border: solid 1px rgb(117, 48, 150);
  box-shadow: 5px 5px 15px rgb(117, 48, 150);
  width: 85%;
  align-self: center;
  height: 450px;
}

.activity-main-loaded{
  display: flex;
  flex-direction: column;
}

#add-activities {
  text-align: center;
  border: solid 1px rgb(48, 124, 58);
  box-shadow: 5px 5px 15px rgb(58, 97, 66);
  width: 450px;
  height: auto;
  padding-bottom:30px;
  margin-left: auto;
  margin-right:auto; 
}

.activity-carousel-inner{
  display:flex;
  justify-content: center;
  margin-top:-40px;
}


</style>