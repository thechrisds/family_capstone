<template>
    <div>
    <view-book />
    <router-link to="/books/add"> Add A Book To Library </router-link>
    </div>
</template>

<script>
import ViewBook from '@/components/ViewBook'

export default ({
    components: {
        ViewBook
    }
});
</script>
