<template>
  <div id="family-account">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else id="main-family">
      <div class="row-1">
        <div id="family-library">
          <div class="family-library-title">Library.</div>
          <div class="family-library-books-container">
            <div class=family-library-books>
          <personal-book />
          </div>
          </div>
        </div>
        
      </div>
      <div id="row-2">
        <div id="account-list-box"><account-list class="account-list-component"/></div>
        <div id="add-user-box"><add-user /></div>
      </div>
      <div class="row-3">
          <div class="prizes-title">Prizes.</div>
          <div class="fa-prize-table">
            <prize-table />
            <div class="prizes-link-div">
            <router-link class="prizes-link" v-bind:to="{name: 'prizes'}">See all prizes.</router-link>
          </div>
          </div>
          
        </div>
    </div>
    
  </div>
</template>

<script>
import AccountList from "@/components/AccountList";
import AddUser from "@/components/AddUser";
import bookService from "@/services/BookService.js";
import PrizeTable from "@/components/PrizeTable";
import PersonalBook from "@/components/PersonalBook"

export default {
  components: {
    AccountList,
    AddUser,
    PrizeTable,
    PersonalBook
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
  flex-direction: column;
}

.row-1{
  margin-top:60px;
  display: flex;
  justify-content: center;
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

#family-library {
  display: flex;
  flex-direction: column;
  width: 90%;
  height: 350px;
  margin-top: 20px;
  border-radius: 10px;
  font-size: 18px;
  background-color: #a8d0e6;
  color:white;
  font-weight: 600;
}

.family-library-title {
   margin-top:15px;
  margin-left:-30px;
  width: 90%;
  align-self: center;
}
.family-library-books-container{
  height:300px;
}

.family-library-books {
  scroll-snap-type: x mandatory;
  scroll-behavior: smooth;
  width: 95%;
  height: 620px;
  overflow-x: scroll;
  overflow-y: hidden;
  border-radius: 5px;
  display: flex;
}

.family-library-books::-webkit-scrollbar {
  width: 3px;               /* width of the entire scrollbar */
}

.family-library-books::-webkit-scrollbar-thumb {
  background-color: rgb(221, 221, 233);    /* color of the scroll thumb */
  border-radius: 3px;       /* roundness of the scroll thumb */
}
.family-library-books::-webkit-scrollbar-track {
  box-shadow: inset 0 0 3px rgb(202, 182, 182);
  border-radius: 3px;
}

.fa-book-title {
  font-size: 1vw;
}
.fa-book-author {
  font-size: .8vw;
}

.fa-book-description {
  font-size: .7vw;
}

.fa-null-description {
  font-size: .7vw;
}

#row-2 {
  display: flex;
  flex-direction: row;
  margin-top: 19px;
  margin-left:auto;
  margin-right:auto;
  justify-content: space-between;
  width:90%
}

#add-user-box{
  height: 300px;
}

.row-3{
  width: 90%;
  height: 400px;
  margin-top: 20px;
  border-radius: 10px;
  font-size: 18px;
  background-color: #374785;
  margin-left:auto;
  margin-right:auto;
  margin-bottom:30px;
}

.prizes-title {
  color:#f8e9a1;
  font-weight: 600;
  margin-left:40px;
  padding-top:10px;
}

.fa-prize-table {
  width: 650px;
  align-self: center;
  scroll-behavior: smooth;
  width: 90%;
  height: 350px;
  overflow-x: hidden;
  overflow-y: scroll;
  margin-top:20px;
}

.prizes-link{
  color:#f8e9a1;
  font-weight: 600;
  margin-left:40px;
  padding-top:10px;
  text-decoration: none;
  
}

.prizes-link:hover{
color:#a8d0e6;
}


.fa-prize-table::-webkit-scrollbar {
  width: 5px;               /* width of the entire scrollbar */
}

.fa-prize-table::-webkit-scrollbar-thumb {
  background-color: rgb(221, 221, 233);    /* color of the scroll thumb */
  border-radius: 3px;       /* roundness of the scroll thumb */
}
.fa-prize-table::-webkit-scrollbar-track {
  box-shadow: inset 0 0 3px rgb(202, 182, 182);
  border-radius: 3px;
}

</style>