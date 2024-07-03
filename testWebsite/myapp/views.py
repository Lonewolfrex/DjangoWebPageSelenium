from django.shortcuts import render

def home(request):
    return render(request, 'home.html')

def calculator(request):
    if request.method == 'POST':
        result = None
        try:
            expression = request.POST.get('expression', '')
            result = eval(expression)
        except:
            result = "Error"
        return render(request, 'calculator.html', {'result': result})
    return render(request, 'calculator.html')

def fibonacci(request):
    sequence = []
    if request.method == 'POST':
        n = int(request.POST.get('number', '0'))
        a, b = 0, 1
        for _ in range(n):
            sequence.append(a)
            a, b = b, a + b
    return render(request, 'fibonacci.html', {'sequence': sequence})

def palindrome(request):
    result = None
    if request.method == 'POST':
        text = request.POST.get('text', '').strip()
        result = text == text[::-1]
    return render(request, 'palindrome.html', {'result': result})
