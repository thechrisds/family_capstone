
<template>
    <div>
        <div class="bookList" v-for="book in books" v-bind:key="book.bookID" v-bind:book="book">
            {{book.bookTitle}}
            {{book.bookAuthor}}
            
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
        bookService.seeBooks().then( response => {
            this.books = response.data;
            }).catch 
        }
    };
</script>

<style scoped>

</style>