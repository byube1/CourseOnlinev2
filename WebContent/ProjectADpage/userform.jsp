<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="CSS/style.min.css" rel="stylesheet">
    
    <title>User Information</title>
</head>

<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-lg-4 pb-5 infomation-user">
                <!-- Account Sidebar-->
                <div class="author-card pb-3">
                    <div class="author-card-cover"
                        style="background-image: url(https://demo.createx.studio/createx-html/img/widgets/author/cover.jpg);">
                        <a class="btn btn-style-1 btn-white btn-sm" href="#" data-toggle="tooltip" title=""
                            data-original-title="You currently have 290 Reward points to spend"><i
                                class="fa fa-award text-md"></i>&nbsp;1/11/2020</a></div>
                    <div class="author-card-profile">
                        <div class="author-card-avatar"><img src="${DetailUser.getImg()}"
                                alt="Daniel Adams">
                        </div>
                        <div class="author-card-details">
                            <h5 class="author-card-name text-lg">${DetailUser.getName()}</h5>
                            <span class="author-card-position">ID:${DetailUser.getId()}</span>
                        </div>
                    </div>
                </div>
                <div class="wizard">
                    <nav class="list-group list-group-flush">
                        <a class="list-group-item active" href="#">
                            <i class="fe-icon-user text-muted"></i>
                             Profile Settings
                        </a>
                        <a class="list-group-item" href="../ManageUserServlet/show">
                            <div class="d-flex justify-content-between align-items-center">
                                <div>
                                    <i class="fa fa-door-open"></i>
                                    <div class="d-inline-block font-weight-medium text-uppercase">Back</div>
                                </div>
                            </div>
                        </a>                       
                    </nav>
                </div>
            </div>
            <!-- Profile Settings-->
            <div class="col-lg-8 pb-5">
            
                <div class="bgform container py-5">
                <h5 style="text-align: center; color: red;">${Report==nul?"":Report}</h5>
                <%session.removeValue("Report"); %>
                
                    <form class="row" action="../ManageUserServlet/update" method="get">
                         <input class="form-control" type="text" id="account-fn" name="id" hidden="" required value="${DetailUser.getId()}">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="account-fn">Full name</label>
                                <input class="form-control" type="text" id="account-fn" name="name" required value="${DetailUser.getName()}">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="account-ln">Date create</label>
                                <input class="form-control" type="text" id="account-ln" required="" disabled value="${DetailUser.getResgisterDate()}">
                                <input class="form-control" type="text" id="account-ln"  hidden="" name="registerDate" value="${DetailUser.getResgisterDate()}">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="account-email">E-mail address</label>
                                <input class="form-control" type="text" id="account-email"  value="${DetailUser.getEmail()}" disabled> 
                                <input class="form-control" type="text" id="account-email" hidden="" name="email"  value="${DetailUser.getEmail()}" >
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="account-phone">Phone number</label>
                                <input class="form-control" type="text" id="account-phone" name="phone" value="${DetailUser.getPhone()}" >
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="account-pass">Password</label>
                                <input class="form-control" type="text" id="account-pass" name="pass" value="${DetailUser.getPass()}" >
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="account-confirm-pass">Position</label>
                                <select name="type" id="Position" class="form-control">
                                    <option ${DetailUser.getType()==1?'selected="selected"':""} value="1">Admin</option>
                                    <option ${DetailUser.getType()==2?'selected="selected"':""} value="2">User</option>                             
                                 </select>                              
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="account-pass">URL IMG</label>
                                <input class="form-control" type="text" id="account-pass" name="img" value="${DetailUser.getImg()}" >
                            </div>
                        </div>
                        
                        <div class="col-12">
                            <hr class="mt-2 mb-3">
                            <div class="d-flex flex-wrap justify-content-between align-items-center">
                                
                                <button class="btn btn-style-1 btn-primary" type="submit" >Update Profile</button>
                            </div>
                        </div>
                    </form>
                </div>
               
            </div>
        </div>
    </div>   
</body>

</html>