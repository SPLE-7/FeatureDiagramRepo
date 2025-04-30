module librarymanagementsystem.product.default {
    requires vmj.auth.model;
    requires vmj.routing.route;
    requires vmj.hibernate.integrator;
    
    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires jdk.unsupported;

    requires LibraryManagementSystem.daftarbuku.core;
    requires LibraryManagementSystem.daftarbuku.bukufisik;
    requires LibraryManagementSystem.statistik.core;
    requires LibraryManagementSystem.statistik.genrestatistik;
    requires LibraryManagementSystem.peminjamanbuku.core;
    requires LibraryManagementSystem.review.core;
    requires LibraryManagementSystem.review.reviewkomentar;
    requires LibraryManagementSystem.wishlist.core;

}