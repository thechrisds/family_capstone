<template>
  <div class="book-container">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else class="pl-body">
      <personal-book />
      <div class="booklist">
        <router-link class="add-book-link" to="/books/add"> Add A Book To Library </router-link>
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

.add-book-link{
  text-decoration: underline solid transparent;
  transition: text-decoration 1s ease;
  font-weight: 700;
  color: rgb(28, 95, 196);
  font-family: 'Montserrat', sans-serif;
}

.add-book-link:hover{
    text-decoration: underline solid rgb(28, 95, 196);
}

</style>
