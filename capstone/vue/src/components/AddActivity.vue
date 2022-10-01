<template>
  <div class="container">
    <h2>Record your minutes!</h2>
    <div class="activity-form-container">
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
          placeholder="ISBN"
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
        <select name="read-type" id="type" v-model="activity.formatId">
          <option value="" disabled selected>Please Select Type</option>
          <option value="Audiobook">Audiobook</option>
          <option value="Digital">Digital</option>
          <option value="Paper">Paper</option>
          <option value="Read-Aloud (Reader)">Read-Aloud(Reader)</option>
          <option value="Read-Aloud (Listener)">Read-Aloud(Listener)</option>
          <option value="Other">Other</option>
        </select>
        <label for="notes"></label>
        <input
          type="text"
          placeholder="Enter any notes (Optional)"
          name="notes"
          id="notes"
          v-model="activity.activityNotes"
        />
        <input type="submit" />
        <input type="reset" />
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
        readerId: "",
        isbn: "",
        timeInMinutes: 0,
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
        activityNotes: this.activity.activityNotes,
      };
      window.alert("Activity Saved!"), window.location.reload();
      ActivityService.addActivity(activity).then((response) => {
        this.$store.commit("SET_ACTIVITY", response.data);
      });
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.activity-form-container {
  display: flex;
  flex-direction: column;
  border: 2px solid rgb(138, 29, 29);
  text-align: center;
  max-width: 50%;
  padding: 15px;
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