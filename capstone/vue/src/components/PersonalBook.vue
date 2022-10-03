
<template>
  <div class="pb-container">
    <div
      class="pb-bookList"
      v-for="book in books"
      v-bind:key="book.bookID"
      v-bind:book="book"
    >
      <h2 class="pb-book-title">{{ book.bookTitle }}</h2>
      <h3 class="pb-book-author">{{ book.bookAuthor }}</h3>
      <img
        v-if="book.isbn"
        v-bind:src="
          'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
        "
      />
      <p class="pb-book-description">{{ book.description }}</p>
      <p class="pb-null-description" v-if="!book.description">
        No description given
      </p>
    </div>
  </div>
</template>

<script>
import bookService from "@/services/BookService.js";
export default {
  name: "view-book",
  data() {
    return {
      books: [],
      users: [],
      id: "",
      username: this.$store.state.user.username,
    };
  },
  created() {
    bookService.seeBooks().then((response) => {
      this.books = response.data;
    }).catch,
      bookService.see;
  },
};
</script>

<style>
.pb-container {
  display: flex;
  flex-wrap: wrap;
  margin-top:200px;
}


.pb-bookList.read {
  background-color: lightgray;
}

.pb-bookList .book-title {
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  padding:5px;
}

.pb-bookList .book-author {
}
.pb-bookList > img {
  height: 180px;
  width: 150px;
}

.pb-book-description {
    word-wrap: break-word;
    padding:5px;
    overflow-x:hidden;
    overflow-y:auto;

}
</style>