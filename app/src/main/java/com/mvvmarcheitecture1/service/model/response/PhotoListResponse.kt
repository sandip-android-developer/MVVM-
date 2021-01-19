package com.mvvmarcheitecture1.service.model.response

 class PhotoListResponse {
   /* var id:String?=""
    var author:String?=""
    var width:Int?=0
    var height:Int?=0
    var url:String?=""
    var download_url:String?=""*/
   /* val status:String?=""
    val totalResults:Int?=0
    var articles:List<Articles> = ArrayList()
    var source:Source = Source()

    class Source {
      var  id:Any?= null
       var name:String?=""
    }

    class Articles {
         var author:String?=""
         var title:String?=""
         var description:String?=""
         var url:String?=""
         var urlToImage:String?=""
         var publishedAt:String?=""
         var content:String?=""
    }*/

     val page:Int?=0
     val per_page:Int?=0
     val total:Int?=0
     val total_pages:Int?=0
     var data:List<Data> = ArrayList()
     var support:Support = Support()

     class Support {
         var url:String?=""
         var text:String?=""
     }

     class Data {
         var id:Int?=0
         var name:String?=""
         var year:Int?=0
         var color:String?=""
         var pantone_value:String?=""
     }
 }