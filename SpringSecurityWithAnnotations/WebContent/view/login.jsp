<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
  </head>
  <body>
    <hr>
  Custom Login Form
  </hr>
     <div class="container">
      <form class="form-signin" method="post" action="${loginUrl} ">
        <h2 class="form-signin-heading">Please sign in</h2>
        <c:if test="${param.error!=null} }">
        <span style="colour=red">Invalid Credentials</span>
        </c:if>
        <p>
          <label for="username" class="sr-only">Username</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
          <label for="password" class="sr-only">Password</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
          <p>
          <label for="remember-me" class="sr-only">Remember-me</label>
          <input type="checkbox" id="remember-me" name="remember-me" class="form-control" placeholder="Remember-me" checked="checked">
        </p>
<input name="_csrf" type="hidden" name="${_csrf.parameterName} }" value="${_csrf.token}" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
</div>
</body></html>