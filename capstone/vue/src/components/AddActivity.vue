<template>
  <div class="add-activity-container">
    <h2 class="add-activity-title">Record your minutes!</h2>
    <div class="add-activity-form-container">
      <form v-on:submit.prevent="submitForm" class="new-activity-form">
        <label for="userName">Reader: </label>
        <input
          type="text"
          placeholder="UserId"
          name="readerId"
          id="readerId"
          v-model="activity.readerId"
        />

        <label for="title">What did you read?</label>

        <input
          type="text"
          placeholder="Book Id"
          name="current-book"
          id="current-book"
          v-model="activity.isbn"
        />

        <label for="minutes">Minutes read: </label>
        <input
          type="number"
          placeholder="Number of minutes"
          name="minutes"
          id="logged-minutes"
          v-model="activity.timeInMinutes"
        />
        <br />
        <label for="read-type">How did you read?</label>
        <select
          name="read-type"
          type="number"
          id="type"
          v-model="activity.formatId"
        >
          <option value="" disabled selected>Please Select Type</option>
          <option value="1">Paper</option>
          <option value="2">Digital</option>
          <option value="3">Audiobook</option>
          <option value="4">Read-Aloud(Reader)</option>
          <option value="5">Read-Aloud(Listener)</option>
          <option value="0">Other</option>
        </select>
        <label for="notes"></label>
        <input
          type="text"
          placeholder="Enter any notes (Optional)"
          name="notes"
          id="add-activity-notes"
          v-model="activity.activityNotes"
        />
        <div class="add-activity-sub-reset-buttons">
          <input class="add-activity-submit" type="submit" />
          <input class="add-activity-reset" type="reset" />
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import ActivityService from "@/services/ActivityService.js";
export default {
  name: "add-activity",
  data() {
    return {
      activity: {
        isbn: "",
        timeInMinutes: 0,
        formatId: 0,
        activityNotes: "",
      },
    };
  },
  components: {},
  computed: {},
  methods: {
    submitForm() {
      const activity = {
        readerId: this.activity.readerId,
        isbn: this.activity.isbn,
        timeInMinutes: this.activity.timeInMinutes,
        formatId: this.activity.formatId,
        activityNotes: this.activity.activityNotes,
      };
      window.alert("Activity Saved!"), window.location.reload();
      ActivityService.addActivity(activity).then((response) => {
        this.$store.commit("SET_ACTIVITY", response.data);
      });
    },
  },
  created() {
    setTimeout(() => {
      this.isLoading = false;
    }, 1250);
  },
};
</script>

<style scoped>
#readerId {
  box-shadow: 1px 1px 2px gray;
}

#current-book {
  box-shadow: 1px 1px 2px gray;
}

#logged-minutes {
  box-shadow: 1px 1px 2px gray;
}

#type {
  box-shadow: 1px 1px 2px gray;
}

#add-activity-notes {
  box-shadow: 1px 1px 2px gray;
}

.add-activity-title {
  background-color: rgb(152, 230, 152);
  text-shadow: 1px 1px 3px gray;
}

.add-activity-sub-reset-buttons {
  display: flex;
  align-content: center;
  justify-content: space-evenly;
}

.add-activity-submit {
  box-shadow: 2px 2px 2px gray;
}

.add-activity-reset {
  box-shadow: 2px 2px 2px gray;
}

.add-activity-container {
  display: flex;
  flex-direction: column;
  width: 90%;
  height: auto;
  margin-left: auto;
  margin-right: auto;
}

.add-activity-form-container {
  display: flex;
  flex-direction: column;
  border-top: 10px rgb(44, 179, 78) solid;
  border-right: 10px rgb(22, 119, 46) solid;
  border-bottom: 10px solid rgb(15, 80, 18);
  border-left: 10px solid rgb(141, 228, 148);
  box-shadow: 5px 5px 15px rgb(155, 132, 3);
  text-align: center;
  max-width: 85%;
  padding: 15px;
  margin: auto;
  margin-top: 10px;
}

input[type="text"],
select,
textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type="submit"] {
  background-color: #c04c16;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

.row:after {
  content: "";
  display: table;
  clear: both;
}

@media screen and (max-width: 600px) {
  .col-25,
  .col-75,
  input[type="submit"] {
    width: 100%;
    margin-top: 0;
  }
}
</style>