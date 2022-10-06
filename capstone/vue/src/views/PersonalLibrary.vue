<template>
  <div class="book-container">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else class="pl-body">
      <personal-book />
      <div class="booklist">
        <router-link to="/books/add"> Add A Book To Library </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import PersonalBook from "@/components/PersonalBook";

export default {
  components: {
    PersonalBook,
  },
  data() {
    return {
      isLoading: true,
    };
  },
  created() {
    setTimeout(() => {
      this.isLoading = false;
    }, 1250);
  },
};
</script>

<style>
.booklist {
  text-align: center;
  margin-top: 30px;
}
.book-container {
}
.pl-body {
  padding-bottom: 50px;
  padding-top: 100px;
}
</style>
