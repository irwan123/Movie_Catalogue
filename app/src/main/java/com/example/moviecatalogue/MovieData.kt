package com.example.moviecatalogue

import com.example.moviecatalogue.data.model.Movie


object MovieData {
    private val movieTitle = arrayOf("Mortal Engines",
        "Ralph Breaks The Internet",
        "Alita: Battle Angel",
        "Aquaman",
        "Bohemian Rhapsody",
        "Creed",
        "Fantastic Beast : The Crimes of Grindwald",
        "How to Train Your Dragon: The Hidden World",
        "Avengers: Infinity War",
        "Spider-Man: Into the Spider-Verse",
        "Robin Hood",
        "A Start is Born")

    private val movieDesc = arrayOf("Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
    "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
    "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
    "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
    "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
    "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
    "Gellert Grindelwald telah melarikan diri dari penjara dan telah mulai mengumpulkan pengikut ke tujuannya — meninggikan penyihir di atas semua makhluk non-magis. Satu-satunya yang bisa menghentikannya adalah penyihir yang pernah disebutnya sebagai sahabat terdekatnya, Albus Dumbledore. Namun, Dumbledore akan perlu mencari bantuan dari penyihir yang telah menggagalkan Grindelwald sebelumnya, mantan muridnya, Newt Scamander, yang setuju untuk membantu, tidak menyadari bahaya yang ada di depan. Garis-garis digambar saat cinta dan kesetiaan diuji, bahkan di antara teman-teman dan keluarga sejati, di dunia sihir yang semakin terbagi.",
    "Ketika Hiccup memenuhi mimpinya untuk menciptakan utopia naga yang damai, penemuan Toothless 'dari pasangan yang tak teruji dan sukar ditangkap membuat Night Fury menjauh. Ketika bahaya meningkat di rumah dan pemerintahan Hiccup sebagai kepala desa diuji, baik naga dan pengendara harus membuat keputusan yang mustahil untuk menyelamatkan jenis mereka.",
    "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
    "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
    "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
    "A musician helps a young singer find fame as age and alcoholism send his own career into a downward spiral")
    private val movieYear = arrayOf(
        "2018",
        "2018",
        "2019",
        "2018",
        "2018",
        "2015",
        "2018",
        "2019",
        "2018",
        "2018",
        "2018",
        "2018")
    private  val movieRating = arrayOf(
        "69%",
        "72%",
        "72%",
        "69%",
        "80%",
        "74%",
        "69%",
        "78%",
        "83%",
        "84%",
        "59%",
        "76%")
    private val movieDuration = arrayOf(
        "2h 9m",
        "1h 52m",
        "2h 2m",
        "2h 32m",
        "2h 15m",
        "2h 13m",
        "2h 15m",
        "1h 44m",
        "2h 29m",
        "1h 57m",
        "1h 56m",
        "2h 16m")
    private val moviewDirector = arrayOf(
        "Chirstian Rivest",
        "Phil Johnston",
        "Robert Rodriguez",
        "James Wan",
        "Anthony McCarten",
        "Ryan Coogler",
        "David Yates",
        "Dean DeBlois",
        "Anthony Russo",
        "Rodney Rothman",
        "Ben Chandler",
        "Bradley Cooper")
    private val movieLanguage = arrayOf(
        "USA",
        "USA",
        "USA",
        "USA",
        "USA",
        "USA",
        "USA",
        "English",
        "English",
        "English",
        "English",
        "English",
    )
    private val moviewPoster = intArrayOf(
        R.drawable.poster_mortal_engines,
        R.drawable.poster_ralph,
        R.drawable.poster_alita,
        R.drawable.poster_aquaman,
        R.drawable.poster_bohemian,
        R.drawable.poster_creed,
        R.drawable.poster_crimes,
        R.drawable.poster_how_to_train,
        R.drawable.poster_infinity_war,
        R.drawable.poster_spiderman,
        R.drawable.poster_robin_hood,
        R.drawable.poster_a_start_is_born,
    )
}