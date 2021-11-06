<template>
  <div>
    <i class="el-icon-circle-plus-outline" @click="dialogFormVisible = true"></i>
    <el-dialog
      title="Add/Edit Books"
      :visible.sync="dialogFormVisible" @close="clear">
      <el-form v-model="form" style="text-align: left" ref="dataForm">
        <el-form-item label="Title" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.title" autocomplete="off" placeholder="book title"></el-input>
        </el-form-item>
        <el-form-item label="Author" :label-width="formLabelWidth" prop="author">
          <el-input v-model="form.author" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Date" :label-width="formLabelWidth" prop="date">
          <el-input v-model="form.Date" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Press" :label-width="formLabelWidth" prop="press">
          <el-input v-model="form.press" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Cover" :label-width="formLabelWidth" prop="cover">
          <el-input v-model="form.cover" autocomplete="off" placeholder="Image URL"></el-input>
          <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
        </el-form-item>
        <el-form-item label="Info" :label-width="formLabelWidth" prop="abs">
          <el-input type="textarea" v-model="form.abs" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Category" :label-width="formLabelWidth" prop="cid">
          <el-select v-model="form.category.id" placeholder="select category">
            <el-option v-for="(item, index) in categories" :key="index" :label="item.name" :value="item.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="form.id" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="onSubmit">Submit</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import ImgUpload from '../upload/ImgUpload';
export default {
  name: 'EditForm',
  components: {ImgUpload},
  data () {
    return {
      categories: [],
      dialogFormVisible: false,
      form: {
        id: '',
        title: '',
        author: '',
        date: '',
        press: '',
        cover: '',
        abs: '',
        category: {
          id: '',
          name: ''
        }
      },
      formLabelWidth: '120px'
    }
  },
  methods: {
    clear () {
      this.form = {
        id: '',
        title: '',
        author: '',
        date: '',
        press: '',
        cover: '',
        abs: '',
        category: ''
      }
    },
    onSubmit () {
      this.$axios
        .post('/books', {
          id: this.form.id,
          cover: this.form.cover,
          title: this.form.title,
          author: this.form.author,
          date: this.form.date,
          press: this.form.press,
          abs: this.form.abs,
          category: this.form.category
        }).then(resp => {
          if (resp && resp.status === 200) {
            this.dialogFormVisible = false
            this.$emit('onSubmit')
          }
        })
    },
    uploadImg () {
      this.form.cover = this.$refs.imgUpload.url
    }
  }
}
</script>

<style scoped>
.el-icon-circle-plus-outline {
  margin: 50px 0 0 20px;
  font-size: 100px;
  float: left;
  cursor: pointer;
}

</style>
