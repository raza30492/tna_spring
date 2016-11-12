<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Time and Action Calender</title>
        <%@include file="/static/include/common.jsp" %>
        <style >
            #addActivityModal .modal-dialog  {
            width:40%;
            top: 20%;
        }
        .small{
            width: 150px;
        }
        </style>
    </head>
    <body>
        
        <%@include file="/static/include/header.jsp" %>
        <%@include file="/static/include/navbar.jsp" %>
        <div class="wrapper">
            <div class="content">
                <h2>Activties</h2>
                
                <span id="addBtn" class="glyphicon glyphicon-plus-sign green" style="font-size: 50px;"></span>

                
                <!-- Modal -->
                <div class="modal fade" id="addActivityModal" role="dialog">
                    <div class="modal-dialog modal-size1" style="width: 25%;margin-top: 250px">

                        <!-- Modal content-->
                        <div class="modal-content">

                            <div class="modal-header" style="padding:5px;">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4>New Activity</h4>
                            </div>

                            <div class="modal-body" style="padding:20px;">
                                <form role="form" class="form-inline" action="${pageContext.servletContext.contextPath}/admin/activity/add" method="post">
                                    <input type="text" name="activity" class="form-control" placeholder="Enter New Activity"/>
                                    <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Add</button>
                                    
                                </form>
                            </div>
                        </div>

                    </div>
                </div>

                <script>
                $(document).ready(function(){
                    $("#addBtn").click(function(){
                        $("#addActivityModal").modal();
                    });
                });
                </script>

                
            </div>
        </div>
        <%@include file="/static/include/footer.jsp" %>
    </body>
</html>
