import pygame, sys
from pygame.locals import *

pygame.init()

FPS = 30 # frames per second setting
fpsClock = pygame.time.Clock()

# set up the window
DISPLAYSURF = pygame.display.set_mode((800, 600), 0, 32)
pygame.display.set_caption('Animation')

BG = (255, 255, 255)
catImg = pygame.image.load('caterpillar.png') # (50, 50)
catImg_down = pygame.image.load('caterpillar_down.png') # (50, 50)
catImg_left = pygame.image.load('caterpillar_left.png') # (50, 50)
catImg_up = pygame.image.load('caterpillar_up.png') # (50, 50)
x_min = 10
x_max = 400
y_min = 10
y_max = 500
x = x_min
y = y_min
step = 10
direction = 'right'

while True: # the main game loop
	DISPLAYSURF.fill(BG)

	if direction == 'right' and x >= x_max:
		direction = 'down'
	elif direction == 'down' and y >= y_max:
		direction = 'left'
	elif direction == 'left' and x <= x_min:
		direction = 'up'
	elif direction == 'up' and y <= y_min:
		direction = 'right'

	if direction == 'right':
		x += step
		DISPLAYSURF.blit(catImg, (x, y))
	elif direction == 'down':
		y += step
		DISPLAYSURF.blit(catImg_down, (x, y))
	elif direction == 'left':
		x -= step
		DISPLAYSURF.blit(catImg_left, (x, y))
	else:
		y -= step
		DISPLAYSURF.blit(catImg_up, (x, y))

	for event in pygame.event.get():
		if event.type == QUIT:
			pygame.quit()
			sys.exit()

	pygame.display.update()
	fpsClock.tick(FPS)