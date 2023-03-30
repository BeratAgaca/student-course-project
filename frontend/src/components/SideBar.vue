<template>
  <div>
    <div class="mb-16 d-none d-lg-block">
      <v-app-bar style="background-color: #black" dark app height="auto">
        <v-row cols="12">
          <v-col align="center" cols="4">
            <div
              class="white--text text--darken-2 display-1 font-weight-bold pa-2 ma-auto"
            >
              <span>Öğrenci - Kurs Kayıt Sistemi</span>
            </div>
          </v-col>
          <v-col align="center" cols="4">
            <router-link to="/" tag="v-btn">
              <v-btn fab dark large color="#A51384" router:to="'/'">
                <v-icon color="white"> mdi-home </v-icon>
              </v-btn>
            </router-link>
          </v-col>
          <v-col align="center" cols="4">
            <v-btn
              @click="studentDrawer = !studentDrawer"
              class="ma-4 heading-4 font-weight-bold"
              color="orange"
              label
            >
              <v-icon left> mdi-account-circle-outline </v-icon>
              Öğrenciler
            </v-btn>
            <v-btn
              @click="courseDrawer = !courseDrawer"
              color="red"
              label
              class="ma-4 pa-4 heading-4 font-weight-bold"
            >
              <v-icon left> mdi-book-open-variant </v-icon>
              Kurslar
            </v-btn>
          </v-col>
        </v-row>
      </v-app-bar>
    </div>
    <div class="mb-5 d-none d-sm-flex d-lg-none">
      <v-toolbar style="background-color: #black" dark app height="auto">
        <v-row cols="12">
          <v-col align="center" cols="12">
            <div class="white--text text--darken-2 title font-weight-bold pa-2 mt-2">
              <span>Öğrenci Kurs Kayıt Sistemi</span>
            </div>
          </v-col>

          <v-col align="start" cols="4">
            <v-btn
              @click="studentDrawer = !studentDrawer"
              class="ma-4 heading-4 font-weight-bold"
              color="orange"
              label
            >
              <v-icon left> mdi-account-circle-outline </v-icon>
              Öğrenciler
            </v-btn>
          </v-col>
          <v-col align="center" cols="4">
            <router-link to="/" tag="v-btn">
              <v-btn fab dark small color="#A51384" router:to="'/'">
                <v-icon color="white"> mdi-home </v-icon>
              </v-btn>
            </router-link>
          </v-col>
          <v-col align="end" cols="4">
            <v-btn
              @click="courseDrawer = !courseDrawer"
              color="red"
              label
              class="ma-4 pa-4 heading-4 font-weight-bold"
            >
              <v-icon left> mdi-book-open-variant </v-icon>
              Kurslar
            </v-btn>
          </v-col>
        </v-row>
      </v-toolbar>
    </div>
    <div class="mb-5 d-flex d-sm-none">
      <v-toolbar style="background-color: #black" dark app height="auto">
        <v-row cols="12">
          <v-col align="center" cols="12">
            <div class="white--text text--darken-2 title font-weight-bold pa-2 mt-2">
              <span>Öğrenci Kurs Kayıt Sistemi</span>
            </div>
          </v-col>
          <v-col align="center" cols="12">
            <router-link to="/" tag="v-btn">
              <v-btn fab dark small color="#A51384" router:to="'/'">
                <v-icon color="white"> mdi-home </v-icon>
              </v-btn>
            </router-link>
          </v-col>
          <v-col align="start" cols="6">
            <v-btn
              @click="studentDrawer = !studentDrawer"
              class="ma-4 heading-4 font-weight-bold"
              color="orange"
              label
            >
              <v-icon left> mdi-account-circle-outline </v-icon>
              Öğrenciler
            </v-btn>
          </v-col>
            <v-col align="end" cols="6">
            <v-btn
              @click="courseDrawer = !courseDrawer"
              color="red"
              label
              class="ma-4 pa-4 heading-4 font-weight-bold"
            >
              <v-icon left> mdi-book-open-variant </v-icon>
              Kurslar
            </v-btn>
          </v-col>
        </v-row>
      </v-toolbar>
    </div>
    <v-navigation-drawer v-model="studentDrawer" absolute bottom temporary>
      <v-list nav dense class="text-start">
        <h1 style="background-color: aliceblue; color: black" class="text-center my-2">
          Öğrenciler
        </h1>
        <v-list-item v-for="student in students" :key="student.id">
          <v-list-item-content>
            <v-list-item-title>
              <div class="pa-2 ma-2 grey darken-3">
                <h1 class="mb-2">{{ student.name }} - {{ student.gender }}</h1>
                <h3>Puan : {{ student.grade }}</h3>
                <v-list-item v-for="course in student.courses" :key="course.id">
                  <h2>
                    {{ course.name }}
                  </h2>
                </v-list-item>
                <hr />
              </div>
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-navigation-drawer v-model="courseDrawer" absolute bottom temporary>
      <v-list nav dense>
        <h1 style="background-color: aliceblue; color: black" class="text-center my-2">
          Kurslar
        </h1>
        <v-list-item v-for="course in courses" :key="course.id">
          <v-list-item-content>
            <v-spacer></v-spacer>
            <v-list-item-title>
              <div class="grey darken-3 ma-2 pa-2">
                <h1>{{ course.id }} - {{ course.name }} - {{ course.price }}tl</h1>
              </div>
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </div>
</template>

<script lang="ts">
import StudentBtn from "@/types/StudentBtn";
import CourseBtn from "@/types/CourseBtn";
import { ref } from "vue";
export default {
  data() {
    const selectedItem = 0;
    const itemsS = ref<StudentBtn[]>([
      { text: "Kayıtlı Öğrenciler" },
      //buraya getStudent
    ]);
    const itemsC = ref<CourseBtn[]>([
      { text: "Kayıtlı Kurslar" },
      //buraya getCourses
    ]);
    let studentDrawer = false;
    let courseDrawer = false;
    return {
      selectedItem,
      itemsS,
      studentDrawer,
      courseDrawer,
      itemsC,
      students: null,
      courses: null,
    };
  },

  mounted() {
    //getAllStudents list of stuent döndürür
    fetch("http://localhost:8080/api/students")
      .then((response) => response.json())
      .then((data) => {
        this.students = data;
      }),
      //getAllCourseslist of course döndürür
      fetch("http://localhost:8080/api/courses")
        .then((response) => response.json())
        .then((data) => {
          this.courses = data;
        });
  },
  /* methods: {
            getAllStudent(){
                StudentDataService.getAll()
                .then(response => response.json())
                .then((data) => {
                    this.students = data;
                }) 
            }
        } */
};
</script>
