var gulp = require("gulp");
var browserSync = require("browser-sync").create();
var sass = require("gulp-sass");
var autoprefixer = require("gulp-autoprefixer");

var autoprefixerOptions = {
    browsers: ["last 2 versions", "> 5%", "Firefox ESR"]
};

// Static Server + watching scss/html files
gulp.task("serve", ["sass"], function () {

    browserSync.init({
        server: {
            baseDir: "./",
            directory: true
        }
    });

    gulp.watch("scss/*.scss", ["sass"]);
    gulp.watch(["./*.html", "js/*.js"]).on("change", browserSync.reload);
});

// Compile sass into CSS & auto-inject into browsers
gulp.task("sass", function () {
    return gulp.src("scss/*.scss")
        .pipe(sass())
        .pipe(autoprefixer(autoprefixerOptions))
        .pipe(gulp.dest("./css"))
        .pipe(browserSync.stream());
});

gulp.task("default", ["serve"]);