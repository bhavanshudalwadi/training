<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('users', function (Blueprint $table) {
            $table->bigInteger('id')->autoIncrement();
            $table->string('fname', 255)->comment("First Name");
            $table->string('lname', 255)->comment("Last Name");
            $table->string('email', 255)->unique()->comment("Email Address");
            $table->string('password', 255);
            $table->string('phone', 20)->nullable()->comment("Mobile No");
            $table->date('dob')->comment("Date of Birth");
            $table->string('gender', 20);
            $table->string('pincode', 6)->nullable();
            $table->string('country', 255)->nullable();
            $table->string('state', 255)->nullable();
            $table->string('district', 255)->nullable();
            $table->string('address', 2000);
            $table->timestamp('email_verified_at')->nullable();
            $table->rememberToken();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('users');
    }
};
