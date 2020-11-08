<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="CSS/style.min.css" rel="stylesheet">

        <title>Document</title>
    </head>

    <body class="body-course">
        <div id="main-wrapper" class="container mt-4 background-form">

            <div class="row justify-content-center">

                <div class="col-xl-10 m-5">

                    <div class="card border-0">

                        <div class="card-body p-0">

                            <div class="row no-gutters">
                                <div class="col-lg-8">
                                    <div class="p-5">
                                        <div class="mb-5">
                                            <h3 class="h3 font-weight-bold text-theme text-center">Manage course</h3>
                                        </div>
                                        <form action="../ManageCourseServlet/update" method="get" class="row">
                                            <div class="form-group mb-2 col-12">
                                                <label for="exampleInputPassword1">Name</label>
                                                <input type="text" hidden name="CourseID" value="${CourseDetail.getCourseID() }">
                                                <input type="text" class="form-control" id="" name="CourseName" 
                                                       value="${CourseDetail.getCourseName()}" required>
                                                <p style="text-align: center; color: red;">
                                                    <%=(session.getAttribute("ErrorNameCourse") == null) ? "" : session.getAttribute("ErrorNameCourse")%></p>
                                            </div>
                                            <div class="form-group mb-2 col-12">
                                                <label for="exampleInputPassword1">Majors</label>
                                                <select name="Majors" id="Majors" class="form-control">
                                                    <option ${CourseDetail.getCategoryID() == 'FA234'?'selected="selected"':""} value="FA234">Finace &Accounting</option>
                                                    <option ${CourseDetail.getCategoryID() == 'PD209'?'selected="selected"':""} value="PD209">Personal Development</option> 
                                                    <option ${CourseDetail.getCategoryID() == 'DEV201'?'selected="selected"':""} value="DEV201">Development</option>  
                                                </select>

                                            </div>
                                            <div class="form-group mb-2 col-12">
                                                <label for="exampleInputPassword1">Description</label>
                                                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" 
                                                          name="Desc" required>${CourseDetail.getCourseDescription()}</textarea>
                                                <p style="text-align: center; color: red;">
                                                    <%=(session.getAttribute("ErrorDesCourse") == null) ? "" : session.getAttribute("ErrorDesCourse")%></p>
                                            </div>        
                                            <div class="form-group col-12">
                                                <label for="exampleInputEmail1">Url img</label>
                                                <input type="text" class="form-control" id="" 
                                                       name="IMG" value="${CourseDetail.getImg()}" required>
                                            </div>  
                                            <div class="form-group col-12">
                                                <label for="exampleInputEmail1">Price</label>
                                                <input type="number" class="form-control" id="" 
                                                       name="Price" value="${CourseDetail.getCoursePrice()}" required>
                                                <p style="text-align: center; color: red;">
                                                    <%=(session.getAttribute("ErrorPriceCourse") == null) ? "" : session.getAttribute("ErrorPriceCourse")%></p>
                                            </div>  
                                            <div class="col-9 ">
                                                <button type="submit" class="btn btn-theme float-right">Update</button>                                                    
                                            </div>   
                                            <div class="col-3	 ">
                                                <button class="btn btn-theme float-left"> <a style="color: white" href="../ManageCourseServlet/show">Back</a></button>                                    
                                            </div> 

                                        </form>
                                    </div>
                                </div>
                                <div class="col-lg-4 d-none d-lg-inline-block">                    
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="${CourseDetail.getImg()}" alt="Card image cap">
                                        <div class="card-body">
                                            <p class="card-text"><b>ID: </b>${CourseDetail.getCourseID() }  </p>
                                            <p class="card-text"><b>Date create: </b>${CourseDetail.getCourseTime() } </p>
                                            <p class="card-text"><b>Number of people registered:</b>${CourseDetail.getNumberOfStudent() }</p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- end card-body -->
                    </div>
                    <!-- end card -->              
                </div>
                <!-- end col -->
            </div>
            <!-- Row -->
        </div>

    </body>
    <%session.removeValue("ErrorNameCourse");%>
    <%session.removeValue("ErrorDesCourse");%>
    <%session.removeValue("ErrorPriceCourse");%>
</html>