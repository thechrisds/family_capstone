<template>
  <div id="family-account">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else id="main-family">
      <div class="activities-column">
      <div id="family-library">
        <div class="family-library-title">Library</div>
        <div class="family-library-books">
          <div class="show-books">
          <div
            class="books"
            v-for="book in books"
            v-bind:key="book.bookID"
            v-bind:book="book"
          >
            <h2 class="fa-book-title">{{ book.bookTitle }}</h2>
            <h3 class="fa-book-author">{{ book.bookAuthor }}</h3>
            <img class="fa-book-img" 
              v-if="book.isbn"
              v-bind:src="
                'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
              "
            />
            <p class="fa-book-description">{{ book.description }}</p>
            <p class="fa-null-description" v-if="!book.description">
              No description given
            </p>
          </div>
        </div>
    </div>
    </div>
     <div class="prizes-box">
      <div class="prizes-title">Prizes</div>
      <div class="prizes-board">
      </div>
    </div>
      </div>
      <div id="account-column">
        <div id="account-list-box"><account-list /></div>
        <div id="add-user-box"><add-user /></div>
      </div>
    </div>



  </div>
</template>

<script>
import AccountList from "@/components/AccountList";
import AddUser from "@/components/AddUser";
import bookService from "@/services/BookService.js";

export default {
  components: {
    AccountList,
    AddUser,
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

    bookService.seeOpenBooks().then((response) => {
      this.books = response.data;
    }).catch;
  },
};
</script>

<style>
#main-family {
  display: flex;
  justify-content: space-evenly;
}

.book-turner {
  display: flex;
  justify-content: space-evenly;
  align-content: center;
  height: auto;
  width: 250px;
  margin: auto;
  margin-top: 100px;
  margin-bottom: 25px;
}

#account-column {
  display: flex;
  flex-direction: column;
  margin-top:19px;
}
#account-list-box {
  display: flex;
  justify-content: center;
  height: 300px;
  min-height: 0;
  width: 350px;
  box-shadow: 5px 5px 15px rgb(153, 46, 46);
  border: 1px solid rgb(116, 38, 38);
  height: 100%;
  border-radius: 10px;
  padding-bottom: 25px;
  background-color: white;
}

#add-user-box {
  display: flex;
  flex-wrap: wrap;
  box-shadow: 5px 5px 15px rgb(36, 114, 40);
  border: 1px solid rgb(12, 107, 9);
  border-radius: 10px;
  background-color: white;
}

#family-library {
  display: flex;
  flex-direction: column;
  box-shadow: 5px 5px 15px rgb(58, 58, 97);
  border: 1px solid rgb(15, 29, 90);
  width: 700px;
  height: 500px;
  margin-top: 20px;
  border-radius: 10px;
  font-size: 18px;
  background-color: white;
}

.family-library-title {
  background-color: rgb(166, 166, 228);
  width: 90%;
  align-self: center;
}

.family-library-books {
  display: flex;
  align-self: center;
  align-content: center;
  flex-wrap:nowrap;
  justify-content: space-evenly;
  scroll-snap-type: x mandatory;
  scroll-behavior: smooth;
  width:95%;
  height: auto;
  overflow-x: scroll;
  overflow-y: hidden;
  border: solid 3px lavender;
  box-shadow: 5px 5px 3px lavender;
  margin-top: 40px;
  border-radius: 5px;
}

.fa-book-title {
  font-size: 15px;;
}
.fa-book-author {
  font-size: 10px;
}

.fa-book-description {
  font-size: 10px;
}

.fa-null-description{
    font-size: 10px;

}

.books {
  display: flex;
  flex-direction: column;
  border-top: 10px rgb(207, 193, 0) solid;
  border-right: 10px goldenrod solid;
  border-bottom: 10px solid rgb(175, 133, 25);
  border-left: 10px solid rgb(255, 233, 107);
  box-shadow: 5px 5px 15px rgb(155, 132, 3);
  min-width: 200px;
  max-width:200px;
  height: 265px;
  margin: 25px;
  text-align: center;
  background-color: white;
  word-wrap: break-word;
  padding:10px;  

  
}

.fa-book-img{
  width: 140px;
  align-self: center;
}

.show-books {
  display: flex;
  margin-left:1630px;
  height:350px;
  flex-wrap: nowrap;
}

.prizes-box {
  display: flex;
  flex-direction: column;
  box-shadow: 5px 5px 15px rgb(248, 170, 81);
  border: 1px solid rgb(15, 29, 90);
  width: 700px;
  height: 400px;
  margin-top: 20px;
  border-radius: 10px;
  font-size: 18px;
  background-color: white;
}

.prizes-title {
  background-color: rgb(243, 189, 128);
  width: 90%;
  align-self: center;
}

</style>