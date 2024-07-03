from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='home'),
    path('calculator/', views.calculator, name='calculator'),
    path('fibonacci/', views.fibonacci, name='fibonacci'),
    path('palindrome/', views.palindrome, name='palindrome'),
]
