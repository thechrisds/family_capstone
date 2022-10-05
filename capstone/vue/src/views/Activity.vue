<template>
  <div id="activity-main">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else class="activity-main-loaded">
      <div class="outer-reading-log">
        <h2 class="la-title">Activity.</h2>
        <div class="activity-reading-log">
          
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
              <tr
                v-for="displayActivity in displayActivities"
                :key="displayActivity.id"
              >
                <td>{{ displayActivity.userName }}</td>
                <td>{{ displayActivity.bookTitle }}</td>
                <td>{{ displayActivity.dateRead }}</td>
                <td>{{ displayActivity.timeInMinutes }}</td>
                <td>{{ displayActivity.activityNotes }}</td>
              </tr>
            </tbody>
          </table>
          <nav class="activity-pages">
            <ul class="pagination">
              <li class="page-item" v-for="page in pages" :key="page">
                <a class="page-link" href="#" @click="changePage(page)">{{
                  page
                }}</a>
              </li>
            </ul>
          </nav>
        </div>
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
      activitiesPerPage: 5,
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
      this.totalPages = Math.ceil(
        this.activitiesCount / this.activitiesPerPage
      );
      this.displayActivities = this.activities.slice(0, 5);
      this.pages = [...Array(this.totalPages + 1).keys()];
      this.pages.shift();
      // for(let i = 1; i <= this.totalPages.length; i++) {
      //   console.log('i: ', i)
      //   this.pages.push(i);
      // }
    }).catch,
      activityService.see;
  },
  methods: {
    changePage: function (page) {
      this.displayActivities = this.activities.slice(
        page * this.activitiesPerPage - this.activitiesPerPage,
        page * this.activitiesPerPage
      );
      console.log("page: ", page);
    },
  },
};
</script>

<style>
#activity-main {
  margin-top: 100px;
}

.la-title {
  display: flex;
  color:white;
  font-weight: 600;
  font-size: 18px;
  padding-bottom:10px;
  margin-left:25px;
}

.activity-reading-log {
  background-color: white;
  width: 80%;
  align-self: center;
  margin:auto;
  border-radius: 10px;
  height:300px;
}
.outer-reading-log {
background-color: #F76c6c;
width:50%;
height:50%;
border-radius: 10px;
padding-top:20px;
padding-bottom:50px;
}

.activity-main-loaded {
  display: flex;
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