<html>
<head>
    <title>Demo</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<form class="form-container" action="getmessage" method="post">
  <div class="form-title">
    <h2>Get Message</h2>
  </div>
  <input class="form-field" type="text" name="token" pattern="\d+" title="Enter the token number" placeholder="Token" autocomplete="off"/>
  <br/>
  <div class="submit-container">
    <input class="submit-button" type="submit" value="Get Message" />
  </div>
</form>
<div class="form-container">
  <h2>${message}</h2>
</div>
</body>
</html>
