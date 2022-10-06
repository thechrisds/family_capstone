<template>
  <div id="activity-main">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else class="activity-main-loaded">
      <div class="activity-table">
        <h2 class="la-title">Reading Log.</h2>
        <div class="activity-sub">
        <table class="table table-hover">
          <thead>
            <tr class="activity-tr-head">
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
      </div>
     <b-button v-b-toggle.collapse-1 variant="primary" 
     class="toggle-record-activity">Record a reading.</b-button>
      <b-collapse id="collapse-1">
        <div class="content">
        <add-activity />
        </div>
      </b-collapse>
      
      
    </div>
  </div>
</template>

<script>
import AddActivity from "@/components/AddActivity";
import activityService from "@/services/ActivityService.js";


export default {
  data() {
    return {
      button: "",
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
      this.totalPages = Math.ceil(this.activitiesCount / this.activitiesPerPage);
      this.displayActivities = this.activities.slice(0, 5);
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
  },
};
</script>

<style>
#activity-main {
 background-color: #f1f1f1;

}

.activity-tr-head{
  background-color: #24305e;
  border-radius: 10px;
  color:#f76c6c;
}

.pagination{
  display:flex;
  justify-content: center;
}

.toggle-record-activity {
  width: 50%;
  margin-left:auto;
  margin-right:auto;
  background-color: #f76c6c;
}

.btn .toggle-record-activity{
  background-color: #374785;
}



.la-title {
  height: 25px;
  text-align:left;
  margin-top: 20px;
  margin-left:20px;
  width: 100%;
  font-size: 18px;
  color: #374785;
  font-weight: 600;
  padding-bottom:20px;
}

.activity-sub{
  background-color:#f1f1f1;
  width:85%;
  margin-left:auto;
  margin-right:auto;
  border-radius: 10px;
  margin-top: 20px;
}

.activity-table {
  background-color: #f8e9a1;
  width: 90%;
  border-radius: 10px;
  margin-left:auto;
  margin-right:auto;
  padding-bottom:30px;
  margin-top:70px;
}

.activity-main-loaded {
  display: flex;
  flex-direction: column;

}

#add-activities {
  height: auto;
  padding-bottom: 30px;
  margin-left: auto;
  margin-right: auto;
  margin-top:20px;
  width:90%;
  display:flex;
}

.activity-account-list{
  width:50%;

}

</style>
