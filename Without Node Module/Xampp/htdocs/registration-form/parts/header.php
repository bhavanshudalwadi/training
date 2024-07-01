<div class="topbar bg-dark">
    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <ul class="d-flex top-links m-0 p-0 py-2">
                    <li class="ps-0"><a href="<?php echo $app_url; ?>" class="text-decoration-none text-white">Home</a></li>
                    <li><a href="<?php echo $app_url; ?>" class="text-decoration-none text-white">Feedback</a></li>
                    <li><a href="<?php echo $app_url; ?>" class="text-decoration-none text-white">FAQ's</a></li> 
                    <li class="border-0"><a href="<?php echo $app_url; ?>/contact.php" class="text-decoration-none text-white">Contact</a></li>
                </ul>
            </div>
            <div class="col-md-5">
                <ul class="d-flex top-links m-0 p-0 py-2 justify-content-end">
                    <li><a href="#main" class="text-decoration-none text-white">Skip to Main Content</a></li>
                    <li><a href="#" class="text-decoration-none text-white">Sreen Reader Access</a></li>
                    <li class="d-flex align-items-center border-0" style="gap: 10px">
                        <button class="btn p-0 text-white">A-</button>
                        <button class="btn p-0 text-white">A</button>
                        <button class="btn p-0 text-white">A+</button>
        
                        <input type="radio" name="mode" id="mode" />
                        <input type="radio" name="mode" id="mode" checked/>
                    </li>
                </ul>
            </div>
            <div class="col-md-2">
                <ul class="d-flex top-links m-0 p-0 py-2  justify-content-end">
                    <li><button class="btn p-0 text-white">English</button></li>
                    <li class="border-0"><button class="btn p-0 text-white">ગુજરાતી</button></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg" data-bs-theme="dark" style="background-color: #133b6f;">
  <div class="container">
    <a class="navbar-brand" href="#">Sports Authority of Gujarat</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="d-flex" role="search">
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<?php echo $app_url; ?>">Home</a>
                </li>
                <?php if(!isset($_SESSION['id'])): ?>
                    <li class="nav-item">
                        <a class="nav-link" href="<?php echo $app_url; ?>/login.php">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<?php echo $app_url; ?>/register.php">Register</a>
                    </li>
                <?php else: ?>
                    <li class="nav-item">
                        <a class="btn btn-warning ms-3 rounded-3" href="<?php echo $app_url; ?>/logout.php">Logout</a>
                    </li>
                <?php endif; ?>
            </ul>
        </div>
    </div>
  </div>
</nav>
<?php if(isset($page_title)): ?>
<div>
    <div class="pt-5 pb-4" style="background-color: #eb8f0a;">
        <div class="container py-4">
            <h4 class="text-white">Khelmahakumbh - <?php echo $page_title; ?></h4>
            <nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%236c757d'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<?php echo $app_url; ?>">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Khelmahakumbh - <?php echo $page_title; ?></li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<?php endif; ?>