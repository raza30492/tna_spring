<nav id="nav" class="navbar navbar-inverse">
    
    <div class="row">
        <div class="col-md-8">
            <ul class="nav navbar-nav">
                <li>
                    <a href="${pageContext.servletContext.contextPath}/home">Home</a>
                </li>
                <li>
                    <a href="#">TNA</a>
                </li>
                <li>
                    <a href="#">Notice</a>
                </li>
                <li >
                    <a href="#">FAQ</a>
                </li>
                <li >
                    <a href="#">About</a>
                </li>
            </ul>
        
        </div>
        <div class="col-md-4 main-nav">
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${sessionScope['scopedTarget.userPref'].userName != null}">
                       
                        <li class="dropdown">
                            
                            <a class="dropdown-toggle"  data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
                                ${sessionScope['scopedTarget.userPref'].userName}
                            <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <c:if test="${sessionScope['scopedTarget.userPref'].role.value == 'Admin'}" >
                                    <li><a href="#">Profile</a></li>
                                    <li><a href="${pageContext.servletContext.contextPath}/admin/activity/view">Activities</a></li>
                                    <li><a href="#">Buyers</a></li>
                                    <li><a href="#">Users</a></li>
                                    <li><a href="#">Notice</a></li>
                                </c:if>
                              
                                    <li class="divider"></li>
                                    <li><a href="${pageContext.servletContext.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span>  Logout</a></li>
                            </ul>
                            
                            
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="#" id="loginBtn" style="margin-right: 10px"><span class="glyphicon glyphicon-log-in"></span>  Login</a></li>
                    </c:otherwise>
                </c:choose>
                
            </ul>
        </div>
    </div>
</nav>
                                
<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
        <!-- Modal content-->
        <div class="modal-content">
          
            <div class="modal-header" style="padding:35px 50px;">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
            </div>
          
            <div class="modal-body" style="padding:40px 50px;">
                <form role="form" action="${pageContext.servletContext.contextPath}/login" method="post">
                    <div class="form-group inner-addon left-addon">
                        <i class="glyphicon glyphicon-user"></i>
                        <input type="text" name="empId" class="form-control" placeholder="Employee Id"/>
                    </div>
                    <div class="form-group inner-addon left-addon">
                        <i class="glyphicon glyphicon-lock"></i>       
                        <input type="text" name="password" class="form-control" placeholder="**********">
                    </div>
                    <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
                </form>
            </div>
            
            <div class="modal-footer">
                <p><a href="#"> Forgot Password?</a></p>
            </div>
            
        </div>
      
    </div>
</div>

<script>
$(document).ready(function(){
    $("#loginBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>

<style>
  .modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
</style>
 