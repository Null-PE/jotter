<template>
  <div>
    <el-row style="height: 840px;">
      <el-tooltip effect="dark" placement="right" v-for="item in books" :key="item.id">
        <p slot="content" style="font-size: 14px; margin-bottom: 6px;">{{item.title}}</p>
        <p slot="content" style="font-size: 13px; margin-bottom: 6px">
          <span>{{item.author}}</span> /
          <span>{{item.date}}</span> /
          <span>{{item.press}}</span>
        </p>
        <p slot="content" style="width: 300px" class="abstract">{{item.abs}}</p>
        <el-card style="width: 135px; margin-bottom: 20px; height: 233px;float: left; margin-right: 20px" class="book"
                 body-style="padding:10px" shadow="hover">
          <div class="cover">
            <img :src="item.cover" alt="cover">
          </div>
          <div class="info">
            <div class="title">
              <a href="">{{item.title}}</a>
            </div>
          </div>
          <div class="author">{{item.author}}</div>
        </el-card>
      </el-tooltip>
    </el-row>
    <el-row>
      <el-pagination :current-page="1"
                     :page-size="10"
                     :total="20"></el-pagination>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'Books',
  data () {
    return {
      books: [
        {
          cover: 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.com%2FEffective-Java-Joshua-Bloch-ebook%2Fdp%2FB078H61SCH&psig=AOvVaw1taeJSp6-vgfiybGsj63HJ&ust=1635747381238000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCOv_7_8_MCFQAAAAAdAAAAABAE',
          title: 'Effective Java 3rd edition',
          author: 'Joshua Bloch',
          date: '2017-2-27',
          press: '',
          abs: 'Since this Jolt-award winning classic was last updated in 2008, the Java programming environment has changed dramatically. Java 7 and Java 8 introduced new features and functions including, forEach() method in Iterable interface, default and static methods in Interfaces, Functional Interfaces and Lambda Expressions, Java Stream API for Bulk Data Operations on Collections, Java Time API, Collection API improvements, Concurrency API improvements, and Java IO improvements.'
        },
        {
          cover: 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.com%2FEffective-Java-Joshua-Bloch-ebook%2Fdp%2FB078H61SCH&psig=AOvVaw1taeJSp6-vgfiybGsj63HJ&ust=1635747381238000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCOv_7_8_MCFQAAAAAdAAAAABAE',
          title: 'Effective Java 3rd edition',
          author: 'Joshua Bloch',
          date: '2017-2-27',
          press: '',
          abs: 'Since this Jolt-award winning classic was last updated in 2008, the Java programming environment has changed dramatically. Java 7 and Java 8 introduced new features and functions including, forEach() method in Iterable interface, default and static methods in Interfaces, Functional Interfaces and Lambda Expressions, Java Stream API for Bulk Data Operations on Collections, Java Time API, Collection API improvements, Concurrency API improvements, and Java IO improvements.'
        },
        {
          cover: 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.com%2FEffective-Java-Joshua-Bloch-ebook%2Fdp%2FB078H61SCH&psig=AOvVaw1taeJSp6-vgfiybGsj63HJ&ust=1635747381238000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCOv_7_8_MCFQAAAAAdAAAAABAE',
          title: 'Effective Java 3rd edition',
          author: 'Joshua Bloch',
          date: '2017-2-27',
          press: '',
          abs: 'Since this Jolt-award winning classic was last updated in 2008, the Java programming environment has changed dramatically. Java 7 and Java 8 introduced new features and functions including, forEach() method in Iterable interface, default and static methods in Interfaces, Functional Interfaces and Lambda Expressions, Java Stream API for Bulk Data Operations on Collections, Java Time API, Collection API improvements, Concurrency API improvements, and Java IO improvements.'
        },
        {
          cover: 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.com%2FEffective-Java-Joshua-Bloch-ebook%2Fdp%2FB078H61SCH&psig=AOvVaw1taeJSp6-vgfiybGsj63HJ&ust=1635747381238000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCOv_7_8_MCFQAAAAAdAAAAABAE',
          title: 'Effective Java 3rd edition',
          author: 'Joshua Bloch',
          date: '2017-2-27',
          press: '',
          abs: 'Since this Jolt-award winning classic was last updated in 2008, the Java programming environment has changed dramatically. Java 7 and Java 8 introduced new features and functions including, forEach() method in Iterable interface, default and static methods in Interfaces, Functional Interfaces and Lambda Expressions, Java Stream API for Bulk Data Operations on Collections, Java Time API, Collection API improvements, Concurrency API improvements, and Java IO improvements.'
        },
      ]
    }
  }
}
</script>

<style scoped>
.cover{
  width: 115px;
  height: 172px;
  margin-bottom: 7px;
  overflow: hidden;;
  cursor: pointer;
}

img{
  width: 115px;
  height: 172px;
}

.title{
  font-size: 14px;
  text-align: left;
}

.author{
  color: #333;
  width: 102px;
  font-size: 13px;
  margin-bottom: 6px;
  text-align: left;
}

.abstract {
  display: block;
  line-height: 17px;
}

a{
  text-decoration: none;
}

a:link, a:visited, a:focus{
  color: #3377aa;
}

</style>
