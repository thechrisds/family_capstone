<template>
    <div class="book-container">
    <personal-book />
    <div class="booklist">
    <router-link to="/books/add"> Add A Book To Library </router-link>
    </div>
    </div>
</template>

<script>
import PersonalBook from '@/components/PersonalBook'

export default ({
    components: {
        PersonalBook
    }
});
</script>

<style>
.booklist{
    text-align:center;
}

.book-container{
    margin-top: 200px;
    
}
</style>
