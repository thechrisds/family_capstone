<template>
  <div id="all-books-page">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else id="all-books">
      <view-book />

      <router-link to="/books/add" class="add-book">
        Add A Book To Library
      </router-link>
    </div>
  </div>
</template>

<script>
import ViewBook from "@/components/ViewBook";

export default {
  components: {
    ViewBook,
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
#all-books {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  align-content: center;
  min-width: 450px;
  margin-top: 150px;
  margin-bottom: 20px;
  padding-bottom: 20px;
  box-shadow: 10px 10px 25px rgb(153, 46, 46);
}

.add-book {
  color: black;
  text-decoration: none;
  font-size: 15px;
  position: relative;
  text-shadow: 2px 2px 5px rgb(153, 46, 46);
}

</style>
