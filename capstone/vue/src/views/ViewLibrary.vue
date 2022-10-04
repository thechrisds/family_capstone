<template>
  <div id="all-books-page">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else id="all-books">
      <global-book />

      <div class="add-book">
      <button v-on:click.prevent="showForm = true">
        Add A Book To Library
     </button>
      <add-book v-if="showForm" />
    </div>
    </div>
  </div>
</template>

<script>
import GlobalBook from "@/components/GlobalBook";
import AddBook from "@/components/AddBook";


export default {
  components: {
    GlobalBook,
    AddBook
  },
  data() {
    return {
      isLoading: true,
      showForm: false,
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
  flex-direction: column;
  justify-content: space-evenly;
  align-content: center;
  min-width: 600px;
  margin-top: 100px;
  margin-bottom: 20px;
  padding-bottom: 20px;
  box-shadow: 10px 10px 25px rgb(153, 46, 46);
}

.add-book {
  color: black;
  text-decoration: none;
  font-size: 15px;
  
  text-shadow: 2px 2px 5px rgb(153, 46, 46);
}

</style>
