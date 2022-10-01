
<template>
    <div class="container">
        <div class="bookList" v-for="book in books" v-bind:key="book.bookID" v-bind:book="book">
            <h2 class="book-title">{{book.bookTitle}}</h2>
            <h3 class="book-author">{{ book.bookAuthor }}</h3>
            <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
            <p class="book-description">{{ book.description }}</p>
            <p class="null-description" v-if="!book.description"> No description given</p>
            
        </div>
        
     
    </div>
</template>

<script>
import bookService from '@/services/BookService.js';
export default{
    name: 'view-book',
    data(){
        return {
            books: []
        };
    },
    created() {
        bookService.seeOpenBooks().then( response => {
            this.books = response.data;
            }).catch 
        }
    };
</script>

<style>
.container {
    display:flex;
    flex-wrap:wrap;
    justify-content: space-evenly;
    align-content:center;

}
.bookList {
    border: 2px black solid;
    border-radius: 10px;
    width: 250px;
    height: 375px;
    margin: 20px;
    text-align:center;
    background-color:white;
}

.bookList.read {
    background-color: lightgray;
}

.bookList .book-title {
    overflow: hidden;
    white-space:nowrap;
    text-overflow: ellipsis;
    
}

.bookList .book-author {
    
}
.bookList > img{
    height: 180px;
    width: 150px;
}
</style>