<template>
  <div id="activity-main">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else class="activity-main-loaded">
      <div class="activity-sub">
        <h2 class="la-title">Logged Family Reading Activities</h2>
        <table class="table table-hover">
          <thead>
            <tr>
              <th scope="col">Reader</th>
              <th scope="col">Book</th>
              <th scope="col">Date Read</th>
              <th scope="col">Minutes Read</th>
              <th scope="col">Notes</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="displayActivity in displayActivities" :key="displayActivity.id">
              <td>{{ displayActivity.userName }}</td>
              <td>{{ displayActivity.bookTitle }}</td>
              <td>{{ displayActivity.dateRead }}</td>
              <td>{{ displayActivity.timeInMinutes }}</td>
              <td>{{ displayActivity.activityNotes }}</td>
            </tr>
          </tbody>
        </table>
      <nav>
        <ul class="pagination">
          <li class="page-item" v-for="page in pages" :key="page">
            <a class="page-link" href="#" @click="changePage(page)">{{ page }}</a>
          </li>
        </ul>
      </nav>
      </div>
      <div id="add-activities">
        <add-activity />
      </div>
    </div>
  </div>
</template>

<script>
import AddActivity from "@/components/AddActivity";
import activityService from "@/services/ActivityService.js";

export default {
  data() {
    return {
      isLoading: true,
      activities: [],
      activitiesCount: 0,
      activitiesPerPage: 2,
      displayActivities: [],
      currentPageNumber: 1,
      totalPages: 0,
      pages: [],
    };
  },

  components: {
    AddActivity,
  },
  created() {
    setTimeout(() => {
      this.isLoading = false;
    }, 1250);
    activityService.seeFamilyActivity().then((response) => {
      console.log("response: ", response.data);
      this.activities = response.data;
      this.activitiesCount = this.activities.length;
      this.totalPages = Math.ceil(this.activitiesCount / this.activitiesPerPage);
      this.displayActivities = this.activities.slice(0, 2);
      this.pages = [...Array(this.totalPages+1).keys()]
      this.pages.shift()
      // for(let i = 1; i <= this.totalPages.length; i++) {
      //   console.log('i: ', i)
      //   this.pages.push(i);
      // }
    }).catch,
      activityService.see;
  },
  methods: {
    changePage: function (page) {
      this.displayActivities = 
      this.activities.slice((page*this.activitiesPerPage - this.activitiesPerPage), page*this.activitiesPerPage)
      console.log("page: ", page);
    }
  }
};
</script>

<style>
#activity-main {
  margin-top: 70px;
}

.la-title {
  background-color: plum;
  width: 90%;
  align-self: center;
  margin: auto;
}

.activity-sub {
  background-color: hsl(0, 0%, 100%);
  width: 85%;
}

.activity-main-loaded {
  display: flex;
  flex-direction: column;
}

#add-activities {
  text-align: center;
  border: solid 1px rgb(48, 124, 58);
  box-shadow: 5px 5px 15px rgb(58, 97, 66);
  width: 450px;
  height: auto;
  padding-bottom: 30px;
  margin-left: auto;
  margin-right: auto;
}

.activity-carousel-inner {
  display: flex;
  justify-content: center;
  margin-top: -40px;
}
</style>