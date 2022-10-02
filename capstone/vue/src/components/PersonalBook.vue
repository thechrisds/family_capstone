
<template>
  <div class="container">
    <div
      class="bookList"
      v-for="book in books"
      v-bind:key="book.bookID"
      v-bind:book="book"
    >
      <h2 class="book-title">{{ book.bookTitle }}</h2>
      <h3 class="book-author">{{ book.bookAuthor }}</h3>
      <img
        v-if="book.isbn"
        v-bind:src="
          'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
        "
      />
      <p class="book-description">{{ book.description }}</p>
      <p class="null-description" v-if="!book.description">
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
.container {
  display: flex;
  flex-wrap: wrap;
  margin-top:200px;
}
.bookList {
  border-top: 10px rgb(207, 193, 0) solid;
  border-right: 10px goldenrod solid;
  border-bottom: 10px solid rgb(175, 133, 25);
  border-left: 10px solid rgb(255, 233, 107);
  box-shadow: 5px 5px 15px rgb(155, 132, 3);
  width: 250px;
  height: 375px;
  margin: 20px;
  text-align: center;
}

.bookList.read {
  background-color: lightgray;
}

.bookList .book-title {
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  padding:5px;
}

.bookList .book-author {
}
.bookList > img {
  height: 180px;
  width: 150px;
}

.book-description {
    word-wrap: break-word;
    padding:5px;

}
</style>