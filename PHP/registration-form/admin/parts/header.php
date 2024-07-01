<nav class="navbar navbar-expand-lg" data-bs-theme="dark" style="background-color: #133b6f;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Sports Authority of Gujarat - Admin</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="d-flex" role="search">
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<?php echo app_url; ?>">Home</a>
                </li>
                <?php if(!isset($_SESSION['admin_id'])): ?>
                    <li class="nav-item">
                        <a class="nav-link" href="<?php echo app_url; ?>/login.php">Login</a>
                    </li>
                <?php else: ?>
                    <li class="nav-item">
                        <a class="btn btn-warning ms-3 rounded-3" href="<?php echo app_url; ?>/logout.php">Logout</a>
                    </li>
                <?php endif; ?>
            </ul>
        </div>
    </div>
  </div>
</nav>